package trim.api.question.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.member.domain.Member;
import trim.domains.question.adaptor.QuestionAdaptor;
import trim.domains.question.domain.Question;
import trim.domains.question.dto.request.CreateQuestionRequest;
import trim.domains.question.dto.response.FindQuestionResponse;
import trim.domains.question.service.QuestionDomainService;

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
