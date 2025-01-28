package trim.api.domains.comment.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.UseCase;
import trim.domains.board.business.adaptor.QuestionAdaptor;
import trim.domains.comment.business.service.CommentDomainService;
import trim.domains.member.business.adaptor.MemberAdaptor;


@UseCase
@RequiredArgsConstructor
public class WriteQuestionCommentUseCase {

    private final QuestionAdaptor questionAdaptor;
    private final CommentDomainService questionCommentDomainService;
    private final MemberAdaptor memberAdaptor;

    public Long execute(Long memberId, Long questionId, String content){
        return questionCommentDomainService.createComment(
                memberAdaptor.queryMember(memberId),
                questionId,
                content
        ).getId();
    }

}
