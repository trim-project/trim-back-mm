package trim.api.auth.service;

import lombok.RequiredArgsConstructor;
import trim.api.auth.dto.UserInfoDto;
import trim.api.auth.service.helper.GoogleOauthHelper;
import trim.api.auth.vo.OauthUserInfoResponse;
import trim.common.annotation.UseCase;
import trim.domains.member.business.validate.MemberValidator;
import trim.outer.oauth.google.vo.response.GoogleTokenResponse;

@UseCase
@RequiredArgsConstructor
public class GoogleUserInfoUseCase {
    private final GoogleOauthHelper googleOauthHelper;
    private final MemberValidator memberValidator;

    public OauthUserInfoResponse execute(String code) {
        GoogleTokenResponse googleOauthToken = googleOauthHelper.getGoogleOauthToken(code);
        UserInfoDto googleUserInfo = googleOauthHelper.getGoogleUserInfo(googleOauthToken.getAccessToken());
        return googleUserInfo.toResponse(
                memberValidator.isExistsByEmailAndProvider(googleUserInfo.getEmail(), googleUserInfo.getOauthProvider()));
    }
}
