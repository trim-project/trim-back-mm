package trim.api.domains.question.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.question.dto.request.QuestionRequest;
import trim.common.annotation.UseCase;
import trim.domains.member.domain.Member;
import trim.domains.question.service.QuestionDomainService;


@UseCase
@RequiredArgsConstructor
public class CreateQuestionUseCase {

    private final QuestionDomainService questionDomainService;

    @Transactional
    public Long execute(Member writer, QuestionRequest questionRequest) {
        return questionDomainService.writeQuestion(writer, questionRequest.from());
    }

}
