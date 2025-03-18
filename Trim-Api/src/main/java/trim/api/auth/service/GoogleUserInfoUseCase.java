package trim.api.auth.service;

import lombok.RequiredArgsConstructor;
import trim.api.auth.dto.GoogleUserInfoDto;
import trim.api.auth.service.helper.GoogleOauthHelper;
import trim.api.auth.vo.GoogleUserInfoResponse;
import trim.common.annotation.UseCase;
import trim.domains.member.business.validate.MemberValidator;
import trim.outer.oauth.google.vo.response.GoogleTokenResponse;

@UseCase
@RequiredArgsConstructor
public class GoogleUserInfoUseCase {
    private final GoogleOauthHelper googleOauthHelper;
    private final MemberValidator memberValidator;

    public GoogleUserInfoResponse execute(String code) {
        GoogleTokenResponse googleOauthToken = googleOauthHelper.getGoogleOauthToken(code);
        GoogleUserInfoDto googleUserInfo = googleOauthHelper.getGoogleUserInfo(googleOauthToken.getAccessToken());
        return googleUserInfo.toResponse(
                memberValidator.isExistsByEmailAndProvider(googleUserInfo.getEmail(), googleUserInfo.getOauthProvider()));
    }
}
