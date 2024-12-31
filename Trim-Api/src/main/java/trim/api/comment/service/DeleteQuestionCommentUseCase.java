package trim.api.comment.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.UseCase;
import trim.domains.comment.adaptor.QuestionCommentAdaptor;
import trim.domains.comment.domain.QuestionComment;
import trim.domains.comment.service.QuestionCommentDomainService;
import trim.domains.comment.validate.QuestionCommentValidator;
import trim.domains.member.domain.Member;

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
