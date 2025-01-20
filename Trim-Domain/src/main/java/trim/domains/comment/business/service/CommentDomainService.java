package trim.domains.comment.business.service;

import trim.domains.board.dao.domain.Question;
import trim.domains.member.dao.domain.Member;


public interface CommentDomainService {
    Long createQuestionComment(Member writer, Question question, String content);

    void deleteComment(Member writer, Long commentId);

}
