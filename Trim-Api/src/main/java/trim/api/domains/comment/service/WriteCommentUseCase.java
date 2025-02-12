package trim.api.domains.comment.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.UseCase;
import trim.domains.board.business.adaptor.QuestionAdaptor;
import trim.domains.comment.business.service.CommentDomainService;
import trim.domains.member.business.adaptor.MemberAdaptor;


@UseCase
@RequiredArgsConstructor
public class WriteCommentUseCase {

    private final CommentDomainService commentDomainService;
    private final MemberAdaptor memberAdaptor;

    public Long execute(Long memberId, Long questionId, String content){
        return commentDomainService.createComment(
                memberAdaptor.queryMember(memberId),
                questionId,
                content
        ).getId();
    }

}
