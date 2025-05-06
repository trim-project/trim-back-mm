package trim.domains.reply.business.service;

import trim.domains.comment.dao.domain.Comment;
import trim.domains.member.dao.domain.Member;
import trim.domains.reply.dao.entity.Reply;

public interface ReplyDomainService {

    Reply writeReplyOfComment(Comment comment, Member member, String content);
}
