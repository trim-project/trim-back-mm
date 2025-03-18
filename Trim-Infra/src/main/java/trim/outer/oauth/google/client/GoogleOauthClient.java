package trim.outer.oauth.google.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import trim.outer.oauth.google.vo.request.GoogleTokenRequest;
import trim.outer.oauth.google.vo.response.GoogleTokenResponse;

@FeignClient(
        value = "googleOauthClient",
        url = "https://oauth2.googleapis.com"
)
public interface GoogleOauthClient {

    @PostMapping("/token")
    GoogleTokenResponse googleOauth(@RequestBody GoogleTokenRequest googleTokenRequest);
}
