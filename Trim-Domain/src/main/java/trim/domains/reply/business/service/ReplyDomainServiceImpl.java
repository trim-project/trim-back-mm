package trim.domains.reply.business.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainService;
import trim.domains.comment.dao.domain.Comment;
import trim.domains.member.dao.domain.Member;
import trim.domains.member.dao.repository.MemberRepository;
import trim.domains.reply.dao.entity.Reply;
import trim.domains.reply.dao.repository.ReplyRepository;

@DomainService
@RequiredArgsConstructor
public class ReplyDomainServiceImpl implements ReplyDomainService{

    private final ReplyRepository replyRepository;
    private final MemberRepository memberRepository;

    @Override
    public Reply writeReplyOfComment(Comment comment,
                                     Member member,
                                     String content) {

        Reply reply = Reply.builder()
                .comment(comment)
                .member(member)
                .content(content)
                .build();

        return replyRepository.save(reply);
    }
}
