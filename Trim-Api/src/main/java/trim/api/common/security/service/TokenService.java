package trim.api.common.security.service;

import org.springframework.security.core.Authentication;
import trim.api.common.security.dto.JwtToken;

import java.util.Date;

public interface TokenService {
    JwtToken login(String username);
    JwtToken issueTokens(String refreshToken);

    JwtToken generateToken(Authentication authentication);

    Authentication getAuthentication(String accessToken);

    boolean validateToken(String token);

    boolean logout(String refreshToken);

    boolean existsRefreshToken(String refreshToken);

    Date parseExpiration(String token);
}
