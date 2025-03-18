package trim.api.auth.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import trim.api.auth.service.GoogleSocialLoginUseCase;
import trim.api.auth.service.GoogleSocialRegisterUserUseCase;
import trim.api.auth.service.GoogleUserInfoUseCase;
import trim.api.auth.vo.GoogleRegisterUserRequest;
import trim.api.auth.vo.GoogleUserInfoResponse;
import trim.api.common.dto.ApiResponseDto;
import trim.api.common.security.dto.JwtToken;

@Slf4j
@Tag(name = "[소셜 인증]")
@RestController
@RequestMapping("/api/access/oauth")
@RequiredArgsConstructor
public class OAuthAccessApiController {
    private final GoogleUserInfoUseCase googleUserInfoUseCase;
    private final GoogleSocialLoginUseCase googleSocialLoginUseCase;
    private final GoogleSocialRegisterUserUseCase googleSocialRegisterUserUseCase;

    @GetMapping("/google/user-info")
    public ApiResponseDto<GoogleUserInfoResponse> testGoogleOauth(@RequestParam("code") String code) {
        return ApiResponseDto.onSuccess(googleUserInfoUseCase.execute(code));
    }

    @GetMapping("/google/login")
    public ApiResponseDto<JwtToken> googleLogin(@RequestParam String email,
                                                @RequestParam String socialType) {
        return ApiResponseDto.onSuccess(googleSocialLoginUseCase.execute(email, socialType));
    }

    @PostMapping("/google/sign-up")
    public ApiResponseDto<JwtToken> googleSignUp(@RequestBody GoogleRegisterUserRequest googleRegisterUserRequest) {
        return ApiResponseDto.onSuccess(googleSocialRegisterUserUseCase.execute(googleRegisterUserRequest));
    }
}
