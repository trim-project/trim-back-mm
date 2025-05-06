package trim.api.domains.reply.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.common.dto.ApiResponseDto;
import trim.common.annotation.UseCase;
import trim.domains.comment.business.adaptor.CommentAdaptor;
import trim.domains.comment.dao.domain.Comment;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;
import trim.domains.reply.business.service.ReplyDomainService;

@UseCase
@Transactional
@RequiredArgsConstructor
public class WriteReplyOfCommentUseCase {

    private final ReplyDomainService replyDomainService;
    private final CommentAdaptor commentAdaptor;


    public Long execute(Long commentId, Member member, String content) {
        Comment comment = commentAdaptor.queryById(commentId);

        return replyDomainService.writeReplyOfComment(comment, member, content).getId();
    }
}
