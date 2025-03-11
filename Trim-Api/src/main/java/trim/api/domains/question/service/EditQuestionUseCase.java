package trim.api.domains.question.service;

import lombok.RequiredArgsConstructor;
import trim.api.domains.question.vo.request.QuestionRequest;
import trim.common.annotation.UseCase;
import trim.domains.board.business.adaptor.QuestionAdaptor;
import trim.domains.board.business.service.QuestionDomainService;
import trim.domains.board.business.validate.BoardValidate;
import trim.domains.board.dao.domain.Question;
import trim.domains.member.business.adaptor.MemberAdaptor;

@UseCase
@RequiredArgsConstructor
public class EditQuestionUseCase {

    private final QuestionDomainService questionDomainService;
    private final QuestionAdaptor questionAdaptor;
    private final BoardValidate boardValidate;
    private final MemberAdaptor memberAdaptor;

    public void execute(String username, Long questionId, QuestionRequest request){
        Question question = questionAdaptor.queryById(questionId);
        boardValidate.checkIsWriter(memberAdaptor.queryMemberByUsername(username), question);
        questionDomainService.editQuestion(question, request.from());
    }

}
