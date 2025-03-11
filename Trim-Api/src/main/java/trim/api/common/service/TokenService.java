package trim.api.common.service;

import org.springframework.security.core.Authentication;
import trim.api.common.dto.JwtToken;

import java.util.Date;

public interface TokenService {
    JwtToken login(String kakaoEmail);
    JwtToken issueTokens(String refreshToken);

    JwtToken generateToken(Authentication authentication);

    Authentication getAuthentication(String accessToken);

    boolean validateToken(String token);

    boolean logout(String refreshToken);

    boolean existsRefreshToken(String refreshToken);

    Date parseExpiration(String token);
}
