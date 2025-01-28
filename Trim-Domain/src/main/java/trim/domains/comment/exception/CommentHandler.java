package trim.domains.comment.exception;

import trim.common.exception.BaseErrorCode;
import trim.common.exception.GeneralException;
import trim.domains.member.exception.MemberErrorStatus;
import trim.domains.member.exception.MemberHandler;

public class CommentHandler extends GeneralException {
  public static final GeneralException NOT_FOUND =
          new CommentHandler(CommentErrorStatus.COMMENT_NOT_FOUND);
  public static final GeneralException ONLY_WRITER =
          new CommentHandler(CommentErrorStatus.COMMENT_COULD_BE_TOUCHED_BY_ONLY_WRITER);
  public CommentHandler(BaseErrorCode baseErrorCode) {
    super(baseErrorCode);
  }
}
