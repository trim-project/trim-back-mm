package trim.outer.oauth.google.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import trim.outer.oauth.google.vo.response.GoogleTokenResponse;

@FeignClient(
        value = "googleOauthClient",
        url = "https://accounts.google.com/o/oauth2/auth"
)
public interface GoogleOauthClient {

    @PostMapping(
            "?client_id={CLIENT_ID}&redirect_uri={REDIRECT_URI}&response_type=code&scope=email")
    GoogleTokenResponse googleOauth(
            @PathVariable("CLIENT_ID") String clientId,
            @PathVariable("REDIRECT_URI") String redirectUri);
}
