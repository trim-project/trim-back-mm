package trim.domains.avatar.exception;

import trim.common.exception.BaseErrorCode;
import trim.common.exception.GeneralException;

public class AvatarHandler extends GeneralException {

    public static final GeneralException AVATAR_HAIR_NOT_FOUND =
            new AvatarHandler(AvatarErrorStatus.AVATAR_HAIR_NOT_FOUND);

    public static final GeneralException AVATAR_CLOTH_NOT_FOUND =
            new AvatarHandler(AvatarErrorStatus.AVATAR_CLOTH_NOT_FOUND);

    public static final GeneralException AVATAR_EYES_NOT_FOUND =
            new AvatarHandler(AvatarErrorStatus.AVATAR_EYES_NOT_FOUND);

    public static final GeneralException AVATAR_MOUTH_NOT_FOUND =
            new AvatarHandler(AvatarErrorStatus.AVATAR_MOUTH_NOT_FOUND);

    public static final GeneralException AVATAR_ALREADY_PURCHASED_HAIR =
            new AvatarHandler(AvatarErrorStatus.AVATAR_ALREADY_PURCHASED_HAIR);

    public static final GeneralException AVATAR_ALREADY_PURCHASED_CLOTH =
            new AvatarHandler(AvatarErrorStatus.AVATAR_ALREADY_PURCHASED_CLOTH);

    public static final GeneralException AVATAR_ALREADY_PURCHASED_EYES =
            new AvatarHandler(AvatarErrorStatus.AVATAR_ALREADY_PURCHASED_EYES);

    public static final GeneralException AVATAR_ALREADY_PURCHASED_MOUTH =
            new AvatarHandler(AvatarErrorStatus.AVATAR_ALREADY_PURCHASED_MOUTH);

    public AvatarHandler(BaseErrorCode baseErrorCode) {super(baseErrorCode);}

}
