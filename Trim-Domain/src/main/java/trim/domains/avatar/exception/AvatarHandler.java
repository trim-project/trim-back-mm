package trim.domains.avatar.exception;

import trim.common.exception.BaseErrorCode;
import trim.common.exception.GeneralException;

public class AvatarHandler extends GeneralException {

    public static final GeneralException NOT_FOUND =
            new AvatarHandler(AvatarErrorStatus.AVATAR_HAIR_NOT_FOUND);
    public AvatarHandler(BaseErrorCode baseErrorCode) {super(baseErrorCode);}


}
