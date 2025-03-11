package trim.api.domains.comment.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.UseCase;
import trim.domains.comment.business.service.CommentDomainService;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;


@UseCase
@RequiredArgsConstructor
public class WriteCommentUseCase {

    private final CommentDomainService commentDomainService;
    private final MemberAdaptor memberAdaptor;

    public Long execute(Member member, Long questionId, String content){
        return commentDomainService.createComment(
                member,
                questionId,
                content
        ).getId();
    }

}
