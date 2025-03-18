package trim.api.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.auth.dto.GoogleUserInfoDto;
import trim.api.auth.service.helper.GoogleOauthHelper;
import trim.api.common.security.dto.JwtToken;
import trim.api.common.security.service.TokenService;
import trim.api.domains.member.service.RegisterMemberUseCase;
import trim.common.annotation.UseCase;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.business.validate.MemberValidator;
import trim.domains.member.dao.domain.Member;
import trim.outer.oauth.google.vo.response.GoogleTokenResponse;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GoogleSocialLoginUseCase {

    private final GoogleOauthHelper googleOauthHelper;
    private final RegisterMemberUseCase registerMemberUseCase;
    private final MemberValidator memberValidator;
    private final MemberAdaptor memberAdaptor;
    private final TokenService tokenService;

    public JwtToken execute(String code) {
        GoogleTokenResponse googleOauthToken = googleOauthHelper.getGoogleOauthToken(code);
        GoogleUserInfoDto googleUserInfo = googleOauthHelper.getGoogleUserInfo(googleOauthToken.getAccessToken());
        if (!memberValidator.isExistsByEmailAndProvider(googleUserInfo.getEmail(), googleUserInfo.getOauthProvider())) {
            registerMemberUseCase.execute(googleUserInfo.toMemberRequest());
        }
        Member member = memberAdaptor.queryMemberByEmailAndProvider(googleUserInfo.getEmail(), googleUserInfo.getOauthProvider());
        return tokenService.login(member.getProfile().getUsername());
    }
}
