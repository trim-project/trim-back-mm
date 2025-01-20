package trim.domains.comment.business.validate;

import trim.domains.comment.dao.domain.QuestionComment;
import trim.domains.member.dao.domain.Member;

public interface QuestionCommentValidator {

    void checkCanDelete(Member writer, QuestionComment questionComment);

}
