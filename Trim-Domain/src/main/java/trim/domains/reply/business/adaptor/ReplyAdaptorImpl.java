package trim.domains.reply.business.adaptor;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.reply.dao.entity.Reply;
import trim.domains.reply.dao.repository.ReplyRepository;

import java.util.List;

@Adaptor
@RequiredArgsConstructor
public class ReplyAdaptorImpl implements ReplyAdaptor{

    private final ReplyRepository replyRepository;

    @Override
    public List<Reply> queryByCommentId(Long commentId) {
        return replyRepository.findByCommentId(commentId);
    }
}
