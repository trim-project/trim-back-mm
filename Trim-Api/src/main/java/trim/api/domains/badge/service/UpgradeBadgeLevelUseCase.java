package trim.api.domains.badge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.badge.business.adaptor.BadgeAdaptor;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.mission.business.service.MissionDomainService;

@UseCase
@Transactional
@RequiredArgsConstructor
public class UpgradeBadgeLevelUseCase {

    private final BadgeAdaptor badgeAdaptor;
    private final MissionDomainService missionDomainService;
    private final MemberAdaptor memberAdaptor;

    public Integer execute(Long badgeId, Long memberId) {
        Badge badge = badgeAdaptor.queryById(badgeId);
        int nextLevel = badge.getLevel() + 1;
        // TODO need to validate mission
        // GET NEXT BADGE
        Badge nextBadge = badgeAdaptor.queryByContentAndLevel(badge.getBadgeContent(), nextLevel);
        // CREATE NEXT MISSION
        missionDomainService.createMission(nextBadge, memberAdaptor.queryMember(memberId));
        return nextLevel;
    }
}
