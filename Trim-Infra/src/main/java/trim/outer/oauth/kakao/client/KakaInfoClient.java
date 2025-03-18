package trim.outer.oauth.kakao.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import trim.outer.oauth.google.vo.response.GoogleInformationResponse;

import static trim.common.util.StaticValues.AUTHORIZATION;

@FeignClient(
        value = "kakaoInfoClient",
        url = "https://kapi.kakao.com"
)
public interface KakaInfoClient {

    @GetMapping("/v2/user/me")
    GoogleInformationResponse kakaoUserInfo(@RequestHeader(AUTHORIZATION) String requestDto);
}
