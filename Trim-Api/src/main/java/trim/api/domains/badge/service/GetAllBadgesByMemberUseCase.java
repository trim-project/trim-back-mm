package trim.api.domains.badge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.badge.vo.response.BadgeDetailResponse;
import trim.common.annotation.UseCase;
import trim.domains.mission.business.adaptor.MissionAdaptor;
import trim.domains.mission.dao.entity.Mission;

import java.util.List;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetAllBadgesByMemberUseCase {

    private final MissionAdaptor missionAdaptor;

    public List<BadgeDetailResponse> execute(Long memberId) {
        List<Mission> missions = missionAdaptor.queryMissionByMemberId(memberId);
        return missions.stream()
                .map(BadgeDetailResponse::of)
                .toList();
    }
}
