package trim.api.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.common.security.dto.JwtToken;
import trim.api.common.security.service.TokenService;
import trim.common.annotation.UseCase;
import trim.common.exception.ErrorStatus;
import trim.common.exception.GeneralException;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReissueTokenUseCase {

    private final TokenService tokenService;

    public JwtToken execute(String refreshToken) {
        return tokenService.issueTokens(refreshToken);
    }
}
