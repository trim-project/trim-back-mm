package trim.api.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.auth.dto.GoogleUserInfoDto;
import trim.api.auth.helper.GoogleOauthHelper;
import trim.api.common.security.dto.JwtToken;
import trim.api.common.security.service.TokenService;
import trim.common.annotation.UseCase;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;
import trim.outer.oauth.google.vo.response.GoogleTokenResponse;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SocialLoginUseCase {

    private final GoogleOauthHelper googleOauthHelper;
    private final MemberAdaptor memberAdaptor;
    private final TokenService tokenService;

    public JwtToken execute(String code) {
        GoogleTokenResponse googleOauthToken = googleOauthHelper.getGoogleOauthToken(code);
        GoogleUserInfoDto googleUserInfo = googleOauthHelper.getGoogleUserInfo(googleOauthToken.getAccessToken());
        Member member = memberAdaptor.queryMemberByEmailAndProvider(
                googleUserInfo.getEmail(),
                googleUserInfo.getOauthProvider());
        return tokenService.login(member.getProfile().getUsername());
    }
}
