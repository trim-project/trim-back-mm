package trim.domains.mission.exception;

import trim.common.exception.BaseErrorCode;
import trim.common.exception.GeneralException;

public class MissionHandler extends GeneralException {

    public static final GeneralException NOT_FOUND =
            new MissionHandler(MissionErrorStatus.MISSION_NOT_FOUND);
    public static final GeneralException ALREADY_CLEAR =
            new MissionHandler(MissionErrorStatus.MISSION_ALREADY_CLEAR);

    public MissionHandler(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
