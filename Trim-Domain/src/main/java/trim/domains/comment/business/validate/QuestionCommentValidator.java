package trim.domains.comment.business.validate;

import trim.domains.comment.dao.domain.Comment;
import trim.domains.member.dao.domain.Member;

public interface QuestionCommentValidator {

    void checkCanDelete(Member writer, Comment comment);

}
