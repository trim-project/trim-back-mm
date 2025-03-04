package trim.domains.board.dao.repository.querydsl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import trim.domains.board.dao.domain.MajorType;
import trim.domains.board.dao.domain.Question;

import java.util.List;

public interface QuestionQueryRepository {

    Page<Question> searchQuestions(MajorType majorType,
                                   List<String> keywordList,
                                   Pageable pageable);
}
