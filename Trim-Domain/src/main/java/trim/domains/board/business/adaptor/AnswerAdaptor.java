package trim.domains.board.business.adaptor;

import trim.domains.board.dao.domain.Answer;

import java.util.List;

public interface AnswerAdaptor {

    Answer queryById(Long answerId);

    List<Answer> queryByQuestionId(Long questionId);
}
