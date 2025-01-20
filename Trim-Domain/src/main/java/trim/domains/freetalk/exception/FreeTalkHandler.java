package trim.domains.freetalk.exception;

import trim.common.exception.BaseErrorCode;
import trim.common.exception.GeneralException;
import trim.domains.question.exception.QuestionErrorStatus;

public class FreeTalkHandler extends GeneralException {

    public static final GeneralException NOT_FOUND =
            new FreeTalkHandler(FreeTalkErrorStatus.FREE_TALK_NOT_FOUND);
    public static final GeneralException ONLY_WRITER =
            new FreeTalkHandler(FreeTalkErrorStatus.FREE_TALK_COULD_BE_TOUCHED_BY_ONLY_WRITER);

    public FreeTalkHandler(BaseErrorCode baseErrorCode){
        super(baseErrorCode);
    }
}
