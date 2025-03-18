package trim.api.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.auth.dto.GoogleUserInfoDto;
import trim.api.auth.service.helper.GoogleOauthHelper;
import trim.api.common.security.dto.JwtToken;
import trim.api.common.security.service.TokenService;
import trim.common.annotation.UseCase;
import trim.domains.member.business.service.MemberDomainService;
import trim.domains.member.dao.domain.Profile;
import trim.domains.member.dao.domain.Role;
import trim.outer.oauth.google.vo.response.GoogleTokenResponse;

import java.util.UUID;

@UseCase
@Transactional
@RequiredArgsConstructor
public class GoogleSocialRegisterUserUseCase {
    private final GoogleOauthHelper googleOauthHelper;
    private final MemberDomainService memberDomainService;
    private final TokenService tokenService;

    public JwtToken execute(String code) {
        GoogleTokenResponse googleOauthToken = googleOauthHelper.getGoogleOauthToken(code);
        GoogleUserInfoDto googleUserInfo = googleOauthHelper.getGoogleUserInfo(googleOauthToken.getAccessToken());
        Profile profile = Profile.builder()
                .socialType(googleUserInfo.getOauthProvider())
                .email(googleUserInfo.getEmail())
                .username(UUID.randomUUID().toString())
                .build();
        //TODO convert nickname setting
        memberDomainService.registerMember(profile, Role.USER, UUID.randomUUID().toString());
        return tokenService.login(profile.getUsername());
    }
}
