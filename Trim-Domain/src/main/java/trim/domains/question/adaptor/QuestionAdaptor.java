package trim.domains.question.adaptor;

import trim.domains.question.domain.Question;

import java.util.List;

public interface QuestionAdaptor {

    Question queryById(Long questionId);

    List<Question> queryByWriterUsername(String username);

    List<Question> queryAll();
}
