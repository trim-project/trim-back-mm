package trim.domains.question.business.adaptor;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.question.dao.domain.Question;
import trim.domains.question.exception.QuestionHandler;
import trim.domains.question.dao.repository.QuestionRepository;

import java.util.List;

@Adaptor
@RequiredArgsConstructor
public class QuestionAdaptorImpl implements QuestionAdaptor{

    private final QuestionRepository questionRepository;
    @Override
    public Question queryById(Long questionId) {
        return questionRepository.findById(questionId)
                .orElseThrow(() -> QuestionHandler.NOT_FOUND);
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
