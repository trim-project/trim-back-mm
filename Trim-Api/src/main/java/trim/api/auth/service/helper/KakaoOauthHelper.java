package trim.api.auth.service.helper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import trim.api.auth.dto.UserInfoDto;
import trim.common.annotation.Helper;
import trim.common.util.StaticValues;
import trim.domains.member.dao.domain.SocialType;
import trim.outer.oauth.kakao.client.KakaoInfoClient;
import trim.outer.oauth.kakao.client.KakaoOauthClient;
import trim.outer.oauth.kakao.vo.response.KakaoInformationResponse;
import trim.outer.oauth.kakao.vo.response.KakaoTokenResponse;

@Slf4j
@Helper
@RequiredArgsConstructor
public class KakaoOauthHelper {
    private final Environment environment;
    private final KakaoInfoClient kakaoInfoClient;
    private final KakaoOauthClient kakaoOauthClient;

    public KakaoTokenResponse getKakaoOauthToken(String code) {
        return kakaoOauthClient.kakaoOauth(
                environment.getProperty("oauth2.kakao.client_id"),
                environment.getProperty("oauth2.kakao.redirect_callback"),
                code,
                environment.getProperty("oauth2.kakao.client_secret")
        );
    }

    public UserInfoDto getKakaoUserInfo(String oauthAccessToken) {
        KakaoInformationResponse kakaoInformationResponse =
                kakaoInfoClient.kakaoUserInfo(StaticValues.BEARER + oauthAccessToken);
        return UserInfoDto.builder()
                .email(kakaoInformationResponse.getKakaoAccount().getEmail())
                .oauthId(kakaoInformationResponse.getId())
                .oauthProvider(SocialType.KAKAO)
                .build();
    }
}
