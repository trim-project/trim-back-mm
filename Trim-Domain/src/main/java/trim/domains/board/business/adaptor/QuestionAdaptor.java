package trim.domains.board.business.adaptor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import trim.domains.board.dao.domain.MajorType;
import trim.domains.board.dao.domain.Question;

import java.util.List;

public interface QuestionAdaptor {

    Question queryById(Long questionId);

    List<Question> queryByWriterUsername(String username);

    List<Question> queryAll();

    Page<Question> queryAllQuestion(Pageable pageable);

    Page<Question> queryHotQuestions(Pageable pageable);

    Page<Question> queryQuestionsBySearch(MajorType majorType, List<String> keywordList, Pageable pageable);

}
