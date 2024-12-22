package trim.domains.question.adaptor;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.question.domain.Question;
import trim.domains.question.repository.QuestionRepository;

import java.util.List;

@Adaptor
@RequiredArgsConstructor
public class QuestionAdaptorImpl implements QuestionAdaptor{

    private final QuestionRepository questionRepository;
    @Override
    public Question queryById(Long questionId) {
        return questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("not found question"));
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