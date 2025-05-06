package trim.domains.board.dao.repository.querydsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import trim.domains.board.dao.domain.Knowledge;
import trim.domains.board.dao.domain.MajorType;
import trim.domains.board.dto.KnowledgeSummaryQueryDto;

import java.util.List;

import static trim.domains.board.dao.domain.QKnowledge.knowledge;
import static trim.domains.comment.dao.domain.QComment.comment;
import static trim.domains.like.dao.entity.QLike.like;
import static trim.domains.member.dao.domain.QMember.member;
import static trim.domains.tag.dao.entity.QTag.tag;

@Repository
@RequiredArgsConstructor
public class KnowledgeQueryRepositoryImpl implements KnowledgeQueryRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Knowledge> searchKnowledge(MajorType majorType, List<String> keywordList, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();

        // majorType 필터링
        if (majorType != null) {
            builder.and(knowledge.majorType.eq(majorType));
        }

        // keywordList로 tags.title.content 중 하나라도 매칭되는 조건 구성
        if (keywordList != null && !keywordList.isEmpty()) {
            BooleanBuilder keywordBuilder = new BooleanBuilder();

            for (String keyword : keywordList) {
                keywordBuilder.or(knowledge.title.contains(keyword));
                keywordBuilder.or(knowledge.content.contains(keyword));
                keywordBuilder.or(tag.name.contains(keyword));  // 태그도 동일하게 검색어 적용
            }

            builder.and(keywordBuilder);
        }

        // 태그는 Join 필요
        QueryResults<Knowledge> results = queryFactory
                .selectDistinct(knowledge)
                .from(knowledge)
                .leftJoin(tag).on(tag.boardId.eq(knowledge.id))
                .where(builder)
                .orderBy(knowledge.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }

    @Override
    public List<KnowledgeSummaryQueryDto> findAllKnowledgeSummaries() {
        List<Tuple> tuples = queryFactory
                .select(
                        knowledge.id,
                        knowledge.title,
                        knowledge.content,
                        knowledge.createdAt,
                        knowledge.majorType.stringValue(),

                        member.id,
                        member.profile.email,
                        member.nickname,
                        member.role.stringValue(),
                        member.profile.socialType.stringValue(),

                        JPAExpressions
                                .select(like.count())
                                .from(like)
                                .where(like.boardId.eq(knowledge.id)),

                        JPAExpressions
                                .select(comment.count())
                                .from(comment)
                                .where(comment.boardId.eq(knowledge.id))
                )
                .from(knowledge)
                .join(knowledge.writer, member)
                .fetch();

        return tuples.stream()
                .map(t -> KnowledgeSummaryQueryDto.builder()
                        .knowledgeId(t.get(knowledge.id))
                        .title(t.get(knowledge.title))
                        .content(t.get(knowledge.content))
                        .createdAt(t.get(knowledge.createdAt))
                        .majorType(t.get(knowledge.majorType))

                        .writerId(t.get(member.id))
                        .email(t.get(member.profile.email))
                        .nickname(t.get(member.nickname))
                        .role(t.get(member.role))
                        .socialType(t.get(member.profile.socialType))

                        .likeCount(t.get(10, Long.class))
                        .commentCount(t.get(11, Long.class))
                        .build())
                .toList();
    }
}
