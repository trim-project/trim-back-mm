package trim.api.domains.badge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.badge.business.adaptor.BadgeAdaptor;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.member.business.service.MemberDomainService;
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
    private final MemberDomainService memberDomainService;

    public Integer execute(Long badgeId, Member member) {
        Mission completedMission
                = missionAdaptor.queryMissionByBadgeIdAndMemberId(badgeId, member.getId());
        int nextLevel = completedMission.getBadge().getLevel() + 1;
        // VALIDATE MISSION IS COMPLETED
        if(!missionValidator.isCompletedMission(completedMission)) throw MissionHandler.NOT_CLEARED;
        // CONVERT STATUS GETTO
        completedMission.getto();
        // GET BADGE POINT OF COMPLETED MISSION
        memberDomainService.getPoint(member, completedMission.getBadge().getPoint());
        // GET NEXT BADGE
        Badge nextBadge = badgeAdaptor.queryByContentAndLevel(completedMission.getBadge().getBadgeContent(), nextLevel);
        Mission mission = missionAdaptor.queryMissionByBadgeIdAndMemberId(nextBadge.getId(), member.getId());
        mission.unlocked();
        return nextLevel;
    }
}
