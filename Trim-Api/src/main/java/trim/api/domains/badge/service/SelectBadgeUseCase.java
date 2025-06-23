package trim.api.domains.badge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.badge.business.adaptor.BadgeAdaptor;
import trim.domains.badge.business.validate.BadgeValidator;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.member.dao.domain.Member;
import trim.domains.mission.business.adaptor.MissionAdaptor;
import trim.domains.mission.business.service.MissionDomainService;
import trim.domains.mission.dao.entity.Mission;
import trim.domains.mission.dao.entity.MissionStatus;
import trim.domains.mission.dao.entity.QMission;
import trim.domains.mission.exception.MissionHandler;

import static trim.domains.mission.dao.entity.QMission.mission;

@UseCase
@Transactional
@RequiredArgsConstructor
public class SelectBadgeUseCase {

    private final BadgeValidator badgeValidator;
    private final MissionDomainService missionDomainService;
    private final MissionAdaptor missionAdaptor;
    public Long execute(Member member, Long badgeId) {
        if (!badgeValidator.countAllSelectedBadgeUnderThree(member)) {
            throw MissionHandler.MAXIMUM_SELECTED_BADGE_IS_THREE;
        }
        Mission mission = missionAdaptor.queryMissionByBadgeIdAndMemberId(badgeId, member.getId());
        if (!mission.getMissionStatus().equals(MissionStatus.GETTO)) {
            throw MissionHandler.WRONG_STATUS;
        }
        missionDomainService.selectBadge(mission);
        return mission.getId();
    }
}
