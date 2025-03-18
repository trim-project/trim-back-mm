package trim.api.auth.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GoogleRegisterUserRequest {
    private final String email;
    private final String oauthProvider;
}
