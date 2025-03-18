package trim.outer.oauth.kakao.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import trim.outer.oauth.kakao.vo.response.KakaoTokenResponse;

@FeignClient(
        value = "kakaoOauthClient",
        url = "https://kauth.kakao.com"
)
public interface KakaoOauthClient {

    @PostMapping(value = "/oauth/token?grant_type=authorization_code&client_id={CLIENT_ID}&redirect_uri={REDIRECT_URI}&code={CODE}&client_secret={CLIENT_SECRET}",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    KakaoTokenResponse kakaoOauth(
            @PathVariable("CLIENT_ID") String clientId,
            @PathVariable("REDIRECT_URI") String redirectUri,
            @PathVariable("CODE") String code,
            @PathVariable("CLIENT_SECRET") String client_secret
    );
}
