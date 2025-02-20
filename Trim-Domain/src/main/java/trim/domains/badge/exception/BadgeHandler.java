package trim.domains.badge.exception;

import trim.common.exception.BaseErrorCode;
import trim.common.exception.GeneralException;

public class BadgeHandler extends GeneralException {

    public static final GeneralException NOT_FOUND =
            new BadgeHandler(BadgeErrorStatus.BADGE_NOT_FOUND);
    public BadgeHandler(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
