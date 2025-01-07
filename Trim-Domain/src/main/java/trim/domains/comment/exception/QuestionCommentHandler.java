package trim.domains.comment.exception;

import trim.common.exception.BaseErrorCode;
import trim.common.exception.GeneralException;

public class QuestionCommentHandler extends GeneralException {
    public static final GeneralException NOT_FOUND =
            new QuestionCommentHandler(CommentErrorStatus.QUESTION_COMMENT_NOT_FOUND);
    public static final GeneralException ONLY_WRITER =
            new QuestionCommentHandler(CommentErrorStatus.QUESTION_COMMENT_COULD_BE_TOUCHED_BY_ONLY_WRITER);

    public QuestionCommentHandler(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
