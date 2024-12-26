package trim.api.question.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.question.model.request.CreateQuestionRequest;
import trim.api.question.model.response.CreateQuestionResponse;
import trim.common.annotation.UseCase;
import trim.domains.member.domain.Member;
import trim.domains.question.domain.Question;
import trim.domains.question.dto.request.CreateQuestionRequest;
import trim.domains.question.dto.response.FindQuestionResponse;
import trim.domains.question.service.QuestionDomainService;


@UseCase
@RequiredArgsConstructor
public class CreateQuestionUseCase {

    private final QuestionDomainService questionDomainService;

    @Transactional
    public Long execute(Member writer, CreateQuestionRequest createQuestionRequest) {
        return questionDomainService.writeQuestion(writer, createQuestionRequest);
    }

}
