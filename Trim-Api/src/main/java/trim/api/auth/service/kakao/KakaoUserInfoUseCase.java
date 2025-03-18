package trim.api.auth.service.kakao;

import lombok.RequiredArgsConstructor;
import trim.api.auth.service.helper.KakaoOauthHelper;
import trim.api.auth.vo.OauthUserInfoResponse;
import trim.common.annotation.UseCase;
import trim.domains.member.business.validate.MemberValidator;

@UseCase
@RequiredArgsConstructor
public class KakaoUserInfoUseCase {
    private final KakaoOauthHelper kakaoOauthHelper;
    private final MemberValidator memberValidator;

    public OauthUserInfoResponse execute(String code) {

    }
}
