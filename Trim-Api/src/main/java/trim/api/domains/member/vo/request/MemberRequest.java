package trim.api.domains.member.vo.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class MemberRequest {

    private final String username;
    private final String nickname;
    private final String email;
    private final String socialType;
    private final String role;

}
