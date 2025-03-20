package trim.api.auth.service;

import lombok.RequiredArgsConstructor;
import trim.api.auth.dto.UserInfoDto;
import trim.api.auth.service.helper.KakaoOauthHelper;
import trim.api.auth.vo.OauthUserInfoResponse;
import trim.common.annotation.UseCase;
import trim.domains.member.business.validate.MemberValidator;
import trim.domains.member.dao.domain.SocialType;
import trim.outer.oauth.kakao.vo.response.KakaoTokenResponse;

@UseCase
@RequiredArgsConstructor
public class KakaoUserInfoUseCase {
    private final KakaoOauthHelper kakaoOauthHelper;
    private final MemberValidator memberValidator;

    public OauthUserInfoResponse execute(String code) {
        KakaoTokenResponse kakaoOauthToken = kakaoOauthHelper.getKakaoOauthToken(code);
        UserInfoDto kakaoUserInfo = kakaoOauthHelper.getKakaoUserInfo(kakaoOauthToken.getAccessToken());
        return kakaoUserInfo.toResponse(
                memberValidator.isExistsByEmailAndProvider(kakaoUserInfo.getEmail(), SocialType.KAKAO)
        );
    }
}
