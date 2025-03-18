package trim.api.auth.dto;

import lombok.Builder;
import lombok.Data;
import trim.api.auth.vo.GoogleUserInfoResponse;
import trim.domains.member.dao.domain.SocialType;

@Builder
@Data
public class GoogleUserInfoDto {
    private final String oauthId;
    private final String email;
    private final SocialType oauthProvider;

    //TODO nickname 설정
    public GoogleUserInfoResponse toResponse(boolean isExist) {
        return GoogleUserInfoResponse.builder()
                .email(this.getEmail())
                .oauthId(this.getOauthId())
                .oauthProvider(this.getOauthProvider())
                .isUserExist(isExist)
                .build();
    }
}
