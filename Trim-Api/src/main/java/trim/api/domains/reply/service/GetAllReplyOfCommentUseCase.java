package trim.api.domains.reply.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.reply.vo.ReplyDetailResponse;
import trim.common.annotation.UseCase;
import trim.domains.reply.business.adaptor.ReplyAdaptor;
import trim.domains.reply.dao.entity.Reply;

import java.util.List;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetAllReplyOfCommentUseCase {

    private final ReplyAdaptor replyAdaptor;


    public List<ReplyDetailResponse> execute(Long commentId) {
        List<Reply> replies = replyAdaptor.queryByCommentId(commentId);
        return replies.stream()
                .map(reply -> ReplyDetailResponse.of(reply))
                .toList();
    }

}
