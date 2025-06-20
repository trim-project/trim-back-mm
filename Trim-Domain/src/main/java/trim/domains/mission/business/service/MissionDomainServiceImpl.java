package trim.domains.mission.business.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainService;
import trim.common.exception.ErrorStatus;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.member.dao.domain.Member;
import trim.domains.mission.dao.entity.Mission;
import trim.domains.mission.dao.entity.MissionStatus;
import trim.domains.mission.dao.repository.MissionRepository;
import trim.domains.mission.exception.MissionHandler;

@DomainService
@RequiredArgsConstructor
public class MissionDomainServiceImpl implements MissionDomainService{

    private final MissionRepository missionRepository;

    @Override
    public Mission createMission(Badge badge, Member member) {
        Mission newMission = Mission.builder()
                .badge(badge)
                .member(member)
                .build();
        return missionRepository.save(newMission);
    }

    @Override
    public Mission createMission(Badge badge, Member member, MissionStatus missionStatus) {
        Mission newMission = Mission.builder()
                .badge(badge)
                .member(member)
                .missionStatus(missionStatus)
                .build();
        return missionRepository.save(newMission);
    }

    @Override
    public Mission selectBadge(Badge badge, Member member) {
        Mission mission = missionRepository.findByBadgeAndMember(badge, member)
                .orElseThrow(() -> MissionHandler.NOT_FOUND);
        mission.selectBadge();
        return mission;
    }
}
