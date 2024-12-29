package trim.domains.comment.validate;

import trim.domains.comment.domain.QuestionComment;
import trim.domains.member.domain.Member;

public interface QuestionCommentValidator {

    void checkCanDelete(Member writer, QuestionComment questionComment);

}
