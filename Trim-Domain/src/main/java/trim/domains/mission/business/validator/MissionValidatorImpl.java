package trim.domains.mission.business.validator;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import trim.common.annotation.DomainValidator;
import trim.domains.mission.dao.entity.Mission;
import trim.domains.mission.dao.entity.MissionStatus;

@DomainValidator
@RequiredArgsConstructor
public class MissionValidatorImpl implements MissionValidator{

    @Override
    public boolean isCompletedMission(Mission mission) {
        return mission.getMissionStatus().equals(MissionStatus.SUCCESS);
    }
}
