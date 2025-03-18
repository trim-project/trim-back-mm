package trim.api.common.auth.dto;

import lombok.Builder;
import lombok.Data;
import trim.domains.member.dao.domain.SocialType;

@Builder
@Data
public class GoogleUserInfoDto {
    private final String oauthId;
    private final String email;
    private final SocialType oauthProvider;
}
