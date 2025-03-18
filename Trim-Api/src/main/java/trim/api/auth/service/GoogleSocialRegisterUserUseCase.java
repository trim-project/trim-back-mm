package trim.api.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.auth.vo.GoogleRegisterUserRequest;
import trim.api.common.security.dto.JwtToken;
import trim.api.common.security.service.TokenService;
import trim.common.annotation.UseCase;
import trim.common.util.EnumConvertUtil;
import trim.domains.member.business.service.MemberDomainService;
import trim.domains.member.dao.domain.Profile;
import trim.domains.member.dao.domain.Role;
import trim.domains.member.dao.domain.SocialType;

import java.util.UUID;

@UseCase
@Transactional
@RequiredArgsConstructor
public class GoogleSocialRegisterUserUseCase {

    private final MemberDomainService memberDomainService;
    private final TokenService tokenService;

    //TODO nickname setting
    public JwtToken execute(GoogleRegisterUserRequest googleRegisterUserRequest) {
        Profile profile = Profile.builder()
                .email(googleRegisterUserRequest.getEmail())
                .socialType(EnumConvertUtil.convert(SocialType.class, googleRegisterUserRequest.getOauthProvider()))
                .username(UUID.randomUUID().toString())
                .build();
        memberDomainService.registerMember(profile, Role.USER, UUID.randomUUID().toString());
        return tokenService.login(profile.getUsername());
    }
}
