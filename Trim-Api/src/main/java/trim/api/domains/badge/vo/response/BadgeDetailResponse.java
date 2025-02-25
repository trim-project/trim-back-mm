package trim.api.domains.badge.vo.response;

import lombok.Builder;
import lombok.Getter;
import trim.api.domains.badge.mapper.BadgeMapper;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.mission.dao.entity.Mission;
import trim.domains.mission.dao.entity.MissionStatus;

import java.util.Optional;

@Getter
@Builder
public class BadgeDetailResponse {

    private final BadgeResponse badgeResponse;
    private final MissionStatus missionStatus;

    public static BadgeDetailResponse of(Mission mission) {
        return BadgeDetailResponse.builder()
                .badgeResponse(BadgeMapper.INSTANCE.toResponseBadge(mission.getBadge()))
                .missionStatus(mission.getMissionStatus())
                .build();
    }
}
