package trim.api.domains.badge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.badge.mapper.BadgeMapper;
import trim.api.domains.badge.vo.response.BadgeDetailResponse;
import trim.api.domains.badge.vo.response.BadgeResponse;
import trim.common.annotation.UseCase;
import trim.domains.member.dao.domain.Member;
import trim.domains.mission.business.adaptor.MissionAdaptor;
import trim.domains.mission.dao.entity.Mission;

import java.util.List;

@UseCase
@Transactional
@RequiredArgsConstructor
public class GetSelectedBadgeUseCase {

    private final MissionAdaptor missionAdaptor;
    public List<BadgeDetailResponse> execute(Member member) {
        List<Mission> missions = missionAdaptor.queryMissionSelected(member);
        return missions.stream()
                .map(mission -> BadgeDetailResponse.builder()
                        .missionStatus(mission.getMissionStatus())
                        .badgeResponse(
                                BadgeMapper.INSTANCE.toResponseBadge(mission.getBadge())
                        )
                        .build())
                .toList();
    }
}
