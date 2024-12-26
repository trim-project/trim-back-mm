package trim.api.question.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.question.adaptor.QuestionAdaptor;
import trim.domains.question.domain.Question;
import trim.domains.question.dto.response.FindQuestionResponse;

@UseCase
@RequiredArgsConstructor
public class FindQuestionUseCase {
    private final QuestionAdaptor questionAdaptor;

    @Transactional
    public FindQuestionResponse execute(Long questionId) {
        Question question = questionAdaptor.queryById(questionId);
        return FindQuestionResponse.of(question);
    }
}
