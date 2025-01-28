package trim.domains.board.business.adaptor;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.board.dao.domain.Question;
import trim.domains.board.dao.repository.QuestionRepository;
import trim.domains.board.exception.BoardHandler;

import java.util.List;

@Adaptor
@RequiredArgsConstructor
public class QuestionAdaptorImpl implements QuestionAdaptor{

    private final QuestionRepository questionRepository;
    @Override
    public Question queryById(Long questionId) {
        return questionRepository.findById(questionId)
                .orElseThrow(() -> BoardHandler.QUESTION_NOT_FOUND);
    }

    @Override
    public List<Question> queryByWriterUsername(String username) {
        return questionRepository.findByWriterProfileUsername(username);
    }

    @Override
    public List<Question> queryAll() {
        return questionRepository.findAll();
    }
}
