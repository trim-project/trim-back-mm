package trim.domains.board.business.adaptor;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.board.dao.domain.Answer;
import trim.domains.board.dao.repository.jpa.AnswerRepository;
import trim.domains.board.exception.BoardHandler;

import java.util.List;

@Adaptor
@RequiredArgsConstructor
public class AnswerAdaptorImpl implements AnswerAdaptor{

    private final AnswerRepository answerRepository;

    @Override
    public Answer queryById(Long answerId) {
        return answerRepository.findById(answerId)
                .orElseThrow(() -> BoardHandler.ANSWER_NOT_FOUND);
    }

    @Override
    public List<Answer> queryByQuestionId(Long questionId) {
        return answerRepository.findByQuestionId(questionId);
    }

    @Override
    public Long queryCountByQuestionId(Long questionId) {
        return answerRepository.countByQuestionId(questionId);
    }
}
