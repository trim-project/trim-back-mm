package trim.domains.question.business.adaptor;

import trim.domains.question.dao.domain.Question;

import java.util.List;

public interface QuestionAdaptor {

    Question queryById(Long questionId);

    List<Question> queryByWriterUsername(String username);

    List<Question> queryAll();
}
