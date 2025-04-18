package trim.api.domains.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import trim.api.domains.member.mapper.MemberMapper;
import trim.api.domains.member.vo.request.MemberRequest;
import trim.common.annotation.UseCase;
import trim.common.util.EnumConvertUtil;
import trim.domains.badge.business.adaptor.BadgeAdaptor;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.member.dao.domain.Member;
import trim.domains.member.dao.domain.Profile;
import trim.domains.member.dao.domain.Role;
import trim.domains.member.business.service.MemberDomainService;
import trim.domains.mission.business.service.MissionDomainService;
import trim.domains.mission.dao.entity.MissionStatus;

import java.util.List;

import static trim.domains.mission.dao.entity.MissionStatus.*;

@Slf4j
@UseCase
@RequiredArgsConstructor
public class RegisterMemberUseCase {

    private final MemberDomainService memberDomainService;
    private final BadgeAdaptor badgeAdaptor;
    private final MissionDomainService missionDomainService;

    public Long execute(MemberRequest memberRequest) {
        Profile profile = MemberMapper.INSTANCE.toProfile(memberRequest);
        Member member = memberDomainService.registerMember(
                profile,
                EnumConvertUtil.convert(Role.class, memberRequest.getRole()),
                memberRequest.getNickname()
        );
        //INIT MISSION(link badge and member)
        List<Badge> badges = badgeAdaptor.queryAllBadge();
        badges.forEach(badge -> {
            MissionStatus missionStatus = badge.getLevel() == 1 ? IN_PROGRESS : LOCKED;
            missionDomainService.createMission(badge, member, missionStatus);
        });

        return member.getId();
    }
}
