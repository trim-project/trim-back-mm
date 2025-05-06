package trim.domains.reply.business.adaptor;

import trim.domains.reply.dao.entity.Reply;

import java.util.List;

public interface ReplyAdaptor {

    List<Reply> queryByCommentId(Long commentId);
}
