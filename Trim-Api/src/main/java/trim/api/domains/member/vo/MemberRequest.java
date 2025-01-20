package trim.api.domains.member.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberRequest {

    private final String username;
    private final String nickname;
    private final String email;
    private final String socialType;
    private final String role;

}
