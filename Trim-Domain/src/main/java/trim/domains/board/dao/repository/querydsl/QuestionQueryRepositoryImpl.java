package trim.domains.board.dao.repository.querydsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import trim.domains.board.dao.domain.MajorType;
import trim.domains.board.dao.domain.Question;

import java.util.List;

import static trim.domains.board.dao.domain.QQuestion.question;
import static trim.domains.tag.dao.entity.QTag.tag;

@Repository
@RequiredArgsConstructor
public class QuestionQueryRepositoryImpl implements QuestionQueryRepository{

    private final JPAQueryFactory queryFactory;

    /**
     *
     * @param majorType
     * @param keywordList
     * @param pageable
     * @return
     */
    @Override
    public Page<Question> searchQuestions(MajorType majorType,
                                          List<String> keywordList,
                                          Pageable pageable) {

        BooleanBuilder builder = new BooleanBuilder();

        // majorType 필터링
        if (majorType != null) {
            builder.and(question.majorType.eq(majorType));
        }

        // keywordList로 tags.title.content 중 하나라도 매칭되는 조건 구성
        if (keywordList != null && !keywordList.isEmpty()) {
            BooleanBuilder keywordBuilder = new BooleanBuilder();

            for (String keyword : keywordList) {
                keywordBuilder.or(question.title.contains(keyword));
                keywordBuilder.or(question.content.contains(keyword));
                keywordBuilder.or(tag.name.eq(keyword));  // 태그도 동일하게 검색어 적용
            }

            builder.and(keywordBuilder);
        }

        // 태그는 Join 필요
        QueryResults<Question> results = queryFactory
                .selectDistinct(question)
                .from(question)
                .leftJoin(tag).on(tag.boardId.eq(question.id))
                .where(builder)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }
}
