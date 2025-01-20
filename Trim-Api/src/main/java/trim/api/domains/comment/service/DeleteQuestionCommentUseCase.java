package trim.api.domains.comment.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.UseCase;
import trim.domains.comment.business.adaptor.QuestionCommentAdaptor;
import trim.domains.comment.dao.domain.QuestionComment;
import trim.domains.comment.business.service.QuestionCommentDomainService;
import trim.domains.comment.business.validate.QuestionCommentValidator;
import trim.domains.member.dao.domain.Member;

@UseCase
@RequiredArgsConstructor
public class DeleteQuestionCommentUseCase {

    private final QuestionCommentAdaptor questionCommentAdaptor;
    private final QuestionCommentValidator questionCommentValidator;
    private final QuestionCommentDomainService questionCommentDomainService;

    public void execute(Member writer, Long questionCommentId){
        QuestionComment questionComment = questionCommentAdaptor.queryById(questionCommentId);
        questionCommentValidator.checkCanDelete(writer, questionComment);
        questionCommentDomainService.deleteQuestionComment(writer, questionComment);
    }

}
