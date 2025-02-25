package trim.api.domains.badge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.badge.dao.entity.BadgeContent;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;
import trim.domains.mission.business.adaptor.MissionAdaptor;
import trim.domains.mission.business.service.MissionDomainService;
import trim.domains.mission.dao.entity.Mission;

@UseCase
@Transactional
@RequiredArgsConstructor
public class CountUpBadgeOfWritingQuestionUseCase {

    private final MissionAdaptor missionAdaptor;
    private final MissionDomainService missionDomainService;
    private final MemberAdaptor memberAdaptor;


    public Long execute(Long memberId) {
        Member member = memberAdaptor.queryMember(memberId);
        Mission mission = missionAdaptor.queryMissionByBadgeContentAndMember(BadgeContent.WRITE_QUESTION, member);
        missionDomainService.countUp(mission);
        return mission.getId();
    }
}
