package trim.outer.oauth.google.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import trim.outer.oauth.google.dto.GoogleRequestAccessTokenDto;

@FeignClient(
        value = "googleInfoClient",
        url="https://oauth2.googleapis.com"
)
public interface GoogleInfoClient {

    @PostMapping("/token")
    ResponseEntity<String> getAccessToken(@RequestBody GoogleRequestAccessTokenDto requestDto);
}
