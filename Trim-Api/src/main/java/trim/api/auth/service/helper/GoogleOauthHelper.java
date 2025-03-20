package trim.api.auth.service.helper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import trim.api.auth.dto.UserInfoDto;
import trim.common.annotation.Helper;
import trim.common.util.StaticValues;
import trim.domains.member.dao.domain.SocialType;
import trim.outer.oauth.google.client.GoogleInfoClient;
import trim.outer.oauth.google.client.GoogleOauthClient;
import trim.outer.oauth.google.vo.response.GoogleInformationResponse;
import trim.outer.oauth.google.vo.response.GoogleTokenResponse;

@Slf4j
@Helper
@RequiredArgsConstructor
public class GoogleOauthHelper {

    private final Environment environment;
    private final GoogleInfoClient googleInfoClient;
    private final GoogleOauthClient googleOauthClient;

    public GoogleTokenResponse getGoogleOauthToken(String code) {
        return googleOauthClient.googleOauth(
                StaticValues.GRANT_TYPE,
                environment.getProperty("oauth2.google.client_id"),
                environment.getProperty("oauth2.google.client_secret"),
                environment.getProperty("oauth2.google.redirect_callback"),
                code
        );
    }

    public UserInfoDto getGoogleUserInfo(String oauthAccessToken) {
        GoogleInformationResponse googleInformationResponse =
                googleInfoClient.googleUserInfo(StaticValues.BEARER + oauthAccessToken);
        return UserInfoDto.builder()
                .email(googleInformationResponse.getEmail())
                .oauthId(googleInformationResponse.getId())
                .oauthProvider(SocialType.GOOGLE)
                .build();
    }


}
