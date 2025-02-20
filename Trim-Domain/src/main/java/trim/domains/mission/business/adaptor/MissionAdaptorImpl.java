package trim.domains.mission.business.adaptor;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.badge.exception.BadgeHandler;
import trim.domains.member.dao.domain.Member;
import trim.domains.mission.dao.entity.Mission;
import trim.domains.mission.dao.repository.MissionRepository;

@Adaptor
@RequiredArgsConstructor
public class MissionAdaptorImpl implements MissionAdaptor{

    private final MissionRepository missionRepository;

    @Override
    public Mission queryMissionByBadgeAndMember(Badge badge, Member member) {
        return missionRepository.findByBadgeAndMember(badge, member)
                .orElseThrow(() -> BadgeHandler.NOT_FOUND);
    }
}
