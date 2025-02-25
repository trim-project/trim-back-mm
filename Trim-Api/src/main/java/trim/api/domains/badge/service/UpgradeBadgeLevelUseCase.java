package trim.api.domains.badge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.badge.business.adaptor.BadgeAdaptor;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;
import trim.domains.mission.business.adaptor.MissionAdaptor;
import trim.domains.mission.business.service.MissionDomainService;
import trim.domains.mission.business.validator.MissionValidator;
import trim.domains.mission.dao.entity.Mission;
import trim.domains.mission.exception.MissionHandler;

@UseCase
@Transactional
@RequiredArgsConstructor
public class UpgradeBadgeLevelUseCase {

    private final BadgeAdaptor badgeAdaptor;
    private final MissionAdaptor missionAdaptor;
    private final MissionValidator missionValidator;
    private final MissionDomainService missionDomainService;

    public Integer execute(Long badgeId, Long memberId) {
        Mission completedMission
                = missionAdaptor.queryMissionByBadgeIdAndMemberId(badgeId, memberId);
        int nextLevel = completedMission.getBadge().getLevel() + 1;
        // VALIDATE MISSION IS COMPLETED
        if(!missionValidator.isCompletedMission(completedMission)) throw MissionHandler.NOT_CLEARED;
        // GET NEXT BADGE
        Badge nextBadge = badgeAdaptor.queryByContentAndLevel(completedMission.getBadge().getBadgeContent(), nextLevel);
        Mission mission = missionAdaptor.queryMissionByBadgeIdAndMemberId(nextBadge.getId(), memberId);
        mission.unlocked();
        return nextLevel;
    }
}
