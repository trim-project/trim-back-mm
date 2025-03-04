package trim.domains.board.business.adaptor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import trim.common.annotation.Adaptor;
import trim.domains.board.dao.domain.MajorType;
import trim.domains.board.dao.domain.Question;
import trim.domains.board.dao.repository.jpa.QuestionRepository;
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

    @Override
    public Page<Question> queryAllQuestion(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public Page<Question> queryHotQuestions(Pageable pageable) {
        return questionRepository.findHotQuestions(pageable);
    }

    @Override
    public Page<Question> queryQuestionsBySearch(MajorType majorType, List<String> keywordList, Pageable pageable) {
        return questionRepository.searchQuestions(majorType, keywordList, pageable);
    }

}
