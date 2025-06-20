package trim.api.domains.badge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.badge.business.service.BadgeDomainService;
import trim.domains.badge.business.validate.BadgeValidator;
import trim.domains.member.dao.domain.Member;
import trim.domains.mission.business.adaptor.MissionAdaptor;
import trim.domains.mission.business.service.MissionDomainService;
import trim.domains.mission.dao.entity.Mission;
import trim.domains.mission.exception.MissionHandler;

@UseCase
@Transactional
@RequiredArgsConstructor
public class UnselectBadgeUseCase {

    private final MissionDomainService missionDomainService;
    private final MissionAdaptor missionAdaptor;
    private final BadgeValidator badgeValidator;
    public Long execute(Member member, Long badgeId) {
        Mission mission = missionAdaptor.queryMissionByBadgeIdAndMemberId(badgeId, member.getId());
        if(badgeValidator.notSelected(mission)) throw MissionHandler.NOT_SELECTED;
        missionDomainService.unselectBadge(mission);
        return mission.getId();
    }
}
