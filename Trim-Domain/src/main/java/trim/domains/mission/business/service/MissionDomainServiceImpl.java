package trim.domains.mission.business.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainService;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.member.dao.domain.Member;
import trim.domains.mission.dao.entity.Mission;
import trim.domains.mission.dao.repository.MissionRepository;

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
    public void countUp(Mission mission) {
        mission.countUp();
    }
}
