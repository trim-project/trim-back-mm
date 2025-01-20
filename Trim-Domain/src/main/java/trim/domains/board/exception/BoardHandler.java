package trim.domains.board.exception;

import trim.common.exception.BaseErrorCode;
import trim.common.exception.GeneralException;
import trim.domains.comment.exception.CommentErrorStatus;
import trim.domains.comment.exception.CommentHandler;

public class BoardHandler extends GeneralException {
  //Board
  public static final GeneralException ONLY_WRITER =
          new BoardHandler(BoardErrorStatus.BOARD_COULD_BE_TOUCHED_BY_ONLY_WRITER);
  public static final GeneralException TYPE_IS_NOT_MATCH =
          new BoardHandler(BoardErrorStatus.BOARD_TYPE_IS_NOT_MATCH);
  //Question
  public static final GeneralException QUESTION_NOT_FOUND =
          new BoardHandler(BoardErrorStatus.QUESTION_NOT_FOUND);
  public static final GeneralException HAVE_ANY_ANSWER =
          new BoardHandler(BoardErrorStatus.QUESTION_HAVE_ANY_ANSWER);
  //FreeTalk
  public static final GeneralException FREE_TALK_NOT_FOUND =
          new BoardHandler(BoardErrorStatus.FREE_TALK_NOT_FOUND);


  public BoardHandler(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
