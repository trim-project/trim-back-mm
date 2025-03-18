package trim.api.common.auth.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import trim.api.common.auth.dto.GoogleUserInfoDto;
import trim.common.annotation.Helper;
import trim.common.util.StaticValues;
import trim.domains.member.dao.domain.SocialType;
import trim.outer.oauth.google.client.GoogleInfoClient;
import trim.outer.oauth.google.client.GoogleOauthClient;
import trim.outer.oauth.google.vo.request.GoogleTokenRequest;
import trim.outer.oauth.google.vo.response.GoogleInformationResponse;
import trim.outer.oauth.google.vo.response.GoogleTokenResponse;

@Helper
@RequiredArgsConstructor
public class GoogleOauthHelper {

    private final Environment environment;
    private final GoogleInfoClient googleInfoClient;
    private final GoogleOauthClient googleOauthClient;

    public GoogleTokenResponse getGoogleOauthToken(String code) {
        return googleOauthClient.googleOauth(
                GoogleTokenRequest.builder()
                        .clientId(environment.getProperty("oauth2.google.client_id"))
                        .clientSecret(environment.getProperty("oauth2.google.client_secret"))
                        .code(code)
                        .redirectUrl(StaticValues.GOOGLE_REDIRECT_URL_LOCAL)
                        .build()
        );
    }

    public GoogleUserInfoDto getGoogleUserInfo(String oauthAccessToken) {
        GoogleInformationResponse googleInformationResponse =
                googleInfoClient.googleUserInfo(StaticValues.BEARER + oauthAccessToken);
        return GoogleUserInfoDto.builder()
                .email(googleInformationResponse.getEmail())
                .oauthId(googleInformationResponse.getId())
                .oauthProvider(SocialType.GOOGLE)
                .build();
    }


}
