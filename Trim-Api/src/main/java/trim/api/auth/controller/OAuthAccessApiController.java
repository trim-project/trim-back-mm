package trim.api.auth.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trim.api.auth.dto.GoogleUserInfoDto;
import trim.api.auth.service.helper.GoogleOauthHelper;
import trim.api.common.dto.ApiResponseDto;
import trim.outer.oauth.google.vo.response.GoogleTokenResponse;

@Slf4j
@Tag(name = "소셜 인증")
@RestController
@RequestMapping("/api/access/oauth")
@RequiredArgsConstructor
public class OAuthAccessApiController {
    private final GoogleOauthHelper googleOauthHelper;

    @GetMapping("/google")
    public ApiResponseDto<GoogleUserInfoDto> testGoogleOauth(@RequestParam("code") String code) {
        GoogleTokenResponse googleOauthToken = googleOauthHelper.getGoogleOauthToken(code);
        return ApiResponseDto.onSuccess(googleOauthHelper.getGoogleUserInfo(googleOauthToken.getAccessToken()));
    }
}
