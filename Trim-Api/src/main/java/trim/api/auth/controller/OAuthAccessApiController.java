package trim.api.auth.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import trim.api.auth.service.*;
import trim.api.auth.vo.RegisterUserRequest;
import trim.api.auth.vo.OauthUserInfoResponse;
import trim.api.common.dto.ApiResponseDto;
import trim.api.common.security.dto.JwtToken;
import trim.api.common.security.service.TokenService;

@Slf4j
@Tag(name = "[소셜 인증]")
@RestController
@RequestMapping("/api/access/oauth")
@RequiredArgsConstructor
public class OAuthAccessApiController {

    private final GoogleUserInfoUseCase googleUserInfoUseCase;
    private final SocialLoginUseCase socialLoginUseCase;
    private final SocialRegisterUserUseCase socialRegisterUserUseCase;
    private final KakaoUserInfoUseCase kakaoUserInfoUseCase;
    private final ReissueTokenUseCase reissueTokenUseCase;

    @GetMapping("/google/user-info")
    public ApiResponseDto<OauthUserInfoResponse> googleUserInfo(@RequestParam("code") String code) {
        return ApiResponseDto.onSuccess(googleUserInfoUseCase.execute(code));
    }

    @GetMapping("/kakao/user-info")
    public ApiResponseDto<OauthUserInfoResponse> kakaoUserInfo(@RequestParam("code") String code) {
        return ApiResponseDto.onSuccess(kakaoUserInfoUseCase.execute(code));
    }

    @GetMapping("/login")
    public ApiResponseDto<JwtToken> oauthLogin(@RequestParam String email,
                                               @RequestParam String socialType) {
        return ApiResponseDto.onSuccess(socialLoginUseCase.execute(email, socialType));
    }

    @PostMapping("/sign-up")
    public ApiResponseDto<JwtToken> oauthSignUp(@RequestBody RegisterUserRequest registerUserRequest) {
        return ApiResponseDto.onSuccess(socialRegisterUserUseCase.execute(registerUserRequest));
    }

    @PutMapping("/reissue")
    public ApiResponseDto<JwtToken> reissueToken(@RequestParam String refreshToken) {
        return ApiResponseDto.onSuccess(reissueTokenUseCase.execute(refreshToken));
    }


}
