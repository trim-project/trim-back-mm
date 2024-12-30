package trim.api.question.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.UseCase;
import trim.domains.member.domain.Member;
import trim.domains.question.service.QuestionDomainService;

@UseCase
@RequiredArgsConstructor
public class DeleteQuestionUseCase {

    private final QuestionDomainService questionDomainService;

    public void deleteQuestion(Member writer, Long questionId){
        questionDomainService.deleteQuestion(writer, questionId);
    }

}
