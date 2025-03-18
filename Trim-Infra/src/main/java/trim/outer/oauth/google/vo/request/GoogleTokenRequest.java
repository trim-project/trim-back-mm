package trim.outer.oauth.google.vo.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class GoogleTokenRequest {

    private final String clientId;
    private final String clientSecret;
    private final String code;
    private final String redirectUrl;

}
