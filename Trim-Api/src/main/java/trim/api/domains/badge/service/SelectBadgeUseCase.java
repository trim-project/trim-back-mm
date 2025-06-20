package trim.api.domains.badge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.badge.business.adaptor.BadgeAdaptor;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.member.dao.domain.Member;
import trim.domains.mission.business.service.MissionDomainService;
import trim.domains.mission.dao.entity.Mission;

@UseCase
@Transactional
@RequiredArgsConstructor
public class SelectBadgeUseCase {

    private final BadgeAdaptor badgeAdaptor;
    private final BadgeValidator badgeValidator;
    private final MissionDomainService missionDomainService;
    public Long execute(Member member, Long badgeId) {
        Badge badge = badgeAdaptor.queryById(badgeId);

        Mission mission = missionDomainService.selectBadge(badge, member);
        return mission.getId();
    }
}
