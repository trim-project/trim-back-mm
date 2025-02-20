package trim.domains.mission.business.validator;

import trim.domains.mission.dao.entity.Mission;

public interface MissionValidator {
    boolean isCompletedMission(Mission mission);
}
