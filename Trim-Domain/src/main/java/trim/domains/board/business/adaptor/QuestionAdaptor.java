package trim.domains.board.business.adaptor;


import trim.domains.board.dao.domain.Question;

import java.util.List;

public interface QuestionAdaptor {

    Question queryById(Long questionId);

    List<Question> queryByWriterUsername(String username);

    List<Question> queryAll();
}
