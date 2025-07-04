package trim.api.domains.badge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.common.exception.ErrorStatus;
import trim.common.exception.GeneralException;
import trim.domains.badge.dao.entity.BadgeContent;
import trim.domains.member.dao.domain.Member;
import trim.domains.mission.business.adaptor.MissionAdaptor;
import trim.domains.mission.dao.entity.Mission;

import java.util.List;
import java.util.Optional;

import static trim.domains.mission.dao.entity.MissionStatus.IN_PROGRESS;

@UseCase
@Transactional
@RequiredArgsConstructor
public class CountUpBadgeUseCase {

    private final MissionAdaptor missionAdaptor;

    public void execute(BadgeContent badgeContent, Member member) {
        List<Mission> missions = missionAdaptor.queryMissionByBadgeContentAndMember(badgeContent, member);
        Optional<Mission> inProgressMission = missions.stream()
                .filter(mission -> mission.getMissionStatus().equals(IN_PROGRESS))
                .findFirst();
        if(inProgressMission.isPresent()) inProgressMission.get().countUp();
    }
}
