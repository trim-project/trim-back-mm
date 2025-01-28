package trim.domains.comment.business.service;

import trim.domains.board.dao.domain.Board;
import trim.domains.board.dao.domain.Question;
import trim.domains.comment.dao.domain.Comment;
import trim.domains.member.dao.domain.Member;


public interface CommentDomainService {
    Comment createComment(Member writer, Long boardId, String content);

    void deleteComment(Member writer, Long commentId);

}
