package trim.domains.badge.business.validate;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainValidator;
import trim.domains.member.dao.domain.Member;
import trim.domains.mission.dao.repository.MissionRepository;
import trim.domains.mission.exception.MissionHandler;

@DomainValidator
@RequiredArgsConstructor
public class BadgeValidatorImpl implements BadgeValidator{

    private final MissionRepository missionRepository;
    @Override
    public boolean countAllSelectedBadgeUnderThree(Member member) {
        long count = missionRepository.countByMemberAndIsSelectedBadgeTrue(member);
        if (count < 0) {
            throw MissionHandler.SELECT_LEAST_AT_ZERO;
        }

        return count >= 3 ? false : true;
    }
}
