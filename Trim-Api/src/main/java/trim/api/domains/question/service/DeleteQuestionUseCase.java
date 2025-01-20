package trim.api.domains.question.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.UseCase;
import trim.domains.board.business.service.QuestionDomainService;
import trim.domains.member.dao.domain.Member;

@UseCase
@RequiredArgsConstructor
public class DeleteQuestionUseCase {

    private final QuestionDomainService questionDomainService;

    public void deleteQuestion(Member writer, Long questionId){
        questionDomainService.deleteQuestion(writer, questionId);
    }

}
