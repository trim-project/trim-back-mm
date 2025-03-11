package trim.api.domains.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.common.dto.JwtToken;
import trim.api.common.service.TokenService;
import trim.common.annotation.UseCase;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginForTestUseCase {

    private final TokenService tokenService;


    public JwtToken execute(String username) {
        return tokenService.login(username);
    }
}
