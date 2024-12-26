package trim.api.question.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.UseCase;
import trim.domains.member.domain.Member;
import trim.domains.question.dto.request.EditQuestionRequest;
import trim.domains.question.service.QuestionDomainService;

@UseCase
@RequiredArgsConstructor
public class EditQuestionUseCase {

    private final QuestionDomainService questionDomainService;

    public void execute(Member writer, Long questionId, EditQuestionRequest request){
        questionDomainService.editQuestion(writer, questionId, request);
    }

}
