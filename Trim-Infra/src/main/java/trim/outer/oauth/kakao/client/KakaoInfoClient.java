package trim.outer.oauth.kakao.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import trim.outer.oauth.kakao.vo.response.KakaoInformationResponse;

import static trim.common.util.StaticValues.AUTHORIZATION;

@FeignClient(
        value = "kakaoInfoClient",
        url = "https://kapi.kakao.com"
)
public interface KakaoInfoClient {

    @GetMapping("/v2/user/me")
    KakaoInformationResponse kakaoUserInfo(@RequestHeader(AUTHORIZATION) String requestDto);
}
