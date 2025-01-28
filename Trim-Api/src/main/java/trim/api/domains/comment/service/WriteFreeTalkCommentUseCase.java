package trim.api.domains.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.board.business.adaptor.FreeTalkAdaptor;
import trim.domains.board.dao.domain.FreeTalk;
import trim.domains.comment.business.adaptor.CommentAdaptor;
import trim.domains.comment.business.service.CommentDomainService;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;

@UseCase
@Transactional
@RequiredArgsConstructor
public class WriteFreeTalkCommentUseCase {

    private final CommentDomainService commentDomainService;
    private final MemberAdaptor memberAdaptor;

    public Long execute(Long memberId, Long freeTalkId, String content) {
        Member member = memberAdaptor.queryMember(memberId);
        return commentDomainService.createComment(member, freeTalkId, content).getId();
    }
}
