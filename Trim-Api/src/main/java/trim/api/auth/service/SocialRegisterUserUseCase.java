package trim.api.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.auth.vo.RegisterUserRequest;
import trim.api.common.security.dto.JwtToken;
import trim.api.common.security.service.TokenService;
import trim.common.annotation.UseCase;
import trim.common.util.EnumConvertUtil;
import trim.domains.badge.business.adaptor.BadgeAdaptor;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.member.business.service.MemberDomainService;
import trim.domains.member.dao.domain.Member;
import trim.domains.member.dao.domain.Profile;
import trim.domains.member.dao.domain.Role;
import trim.domains.member.dao.domain.SocialType;
import trim.domains.mission.business.service.MissionDomainService;
import trim.domains.mission.dao.entity.MissionStatus;

import java.util.List;
import java.util.UUID;

import static trim.domains.mission.dao.entity.MissionStatus.IN_PROGRESS;
import static trim.domains.mission.dao.entity.MissionStatus.LOCKED;

@UseCase
@Transactional
@RequiredArgsConstructor
public class SocialRegisterUserUseCase {

    private final MemberDomainService memberDomainService;
    private final TokenService tokenService;
    private final BadgeAdaptor badgeAdaptor;
    private final MissionDomainService missionDomainService;

    //TODO nickname setting
    public JwtToken execute(RegisterUserRequest registerUserRequest) {
        Profile profile = Profile.builder()
                .email(registerUserRequest.getEmail())
                .socialType(EnumConvertUtil.convert(SocialType.class, registerUserRequest.getOauthProvider()))
                .username(UUID.randomUUID().toString())
                .build();
        Member member = memberDomainService.registerMember(profile, Role.USER, UUID.randomUUID().toString());

        //INIT MISSION(link badge and member)
        List<Badge> badges = badgeAdaptor.queryAllBadge();
        badges.forEach(badge -> {
            MissionStatus missionStatus = badge.getLevel() == 1 ? IN_PROGRESS : LOCKED;
            missionDomainService.createMission(badge, member, missionStatus);
        });
        return tokenService.login(profile.getUsername());
    }
}
