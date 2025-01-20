package trim.domains.comment.business.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.DomainService;
import trim.domains.board.dao.domain.Question;
import trim.domains.comment.dao.domain.Comment;
import trim.domains.comment.dao.repository.CommentRepository;
import trim.domains.member.dao.domain.Member;


@DomainService
@Transactional
@RequiredArgsConstructor
public class CommentDomainServiceImpl implements CommentDomainService {

    private final CommentRepository commentRepository;

    @Override
    public Long createQuestionComment(Member writer, Question question, String content) {
        Comment questionComment = Comment.builder()
                .boardId(question.getId())
                .writer(writer)
                .content(content)
                .build();
        return commentRepository.save(questionComment).getId();
    }

    @Override
    public void deleteComment(Member writer, Long commentId) {

    }
}
