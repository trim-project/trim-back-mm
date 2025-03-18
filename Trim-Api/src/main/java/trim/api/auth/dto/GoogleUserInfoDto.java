package trim.api.auth.dto;

import lombok.Builder;
import lombok.Data;
import trim.api.domains.member.vo.request.MemberRequest;
import trim.domains.member.dao.domain.Role;
import trim.domains.member.dao.domain.SocialType;

import java.util.UUID;

@Builder
@Data
public class GoogleUserInfoDto {
    private final String oauthId;
    private final String email;
    private final SocialType oauthProvider;

    //TODO nickname 설정
    public MemberRequest toMemberRequest() {
        return MemberRequest.builder()
                .email(this.getEmail())
                .nickname(UUID.randomUUID().toString())
                .socialType(this.getOauthProvider().getKey())
                .username(UUID.randomUUID().toString())
                .role(Role.USER.getKey())
                .build();
    }
}
