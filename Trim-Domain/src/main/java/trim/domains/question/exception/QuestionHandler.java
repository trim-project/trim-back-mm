package trim.domains.question.exception;

import trim.common.exception.BaseErrorCode;
import trim.common.exception.GeneralException;

public class QuestionHandler extends GeneralException {

    public static final GeneralException NOT_FOUND =
            new QuestionHandler(QuestionErrorStatus.QUESTION_NOT_FOUND);
    public static final GeneralException HAVE_ANY_ANSWER =
            new QuestionHandler(QuestionErrorStatus.QUESTION_HAVE_ANY_ANSWER);
    public static final GeneralException ONLY_WRITER =
            new QuestionHandler(QuestionErrorStatus.QUESTION_COULD_BE_TOUCHED_BY_ONLY_WRITER);

    public QuestionHandler(BaseErrorCode baseErrorCode){
        super(baseErrorCode);
    }
}
