package trim.outer.oauth.google.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import trim.outer.oauth.google.vo.response.GoogleInformationResponse;

import static trim.common.util.StaticValues.AUTHORIZATION;

@FeignClient(
        value = "googleInfoClient",
        url = "https://www.googleapis.com"
)
public interface GoogleInfoClient {

    @GetMapping("/oauth2/v2/userinfo")
    GoogleInformationResponse googleUserInfo(@RequestHeader(AUTHORIZATION) String requestDto);
}
