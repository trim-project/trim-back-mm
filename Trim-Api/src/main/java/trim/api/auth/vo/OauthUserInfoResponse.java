package trim.api.auth.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.domains.member.dao.domain.SocialType;

@Getter
@Builder
@RequiredArgsConstructor
public class OauthUserInfoResponse {
    private final String oauthId;
    private final String email;
    private final SocialType oauthProvider;
    private final boolean isUserExist;
}
