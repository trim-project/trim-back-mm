package trim.api.member.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.domains.member.domain.Role;
import trim.domains.member.domain.SocialType;

@Getter
@RequiredArgsConstructor
public class MemberRequest {

    private final String username;
    private final String nickname;
    private final String email;
    private final String socialType;
    private final String role;

}
