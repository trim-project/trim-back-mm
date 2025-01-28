package trim.api.domains.member.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.domains.member.dao.domain.Role;
import trim.domains.member.dao.domain.SocialType;

@Getter
@Builder
@RequiredArgsConstructor
public class MemberResponse {
    private final Long memberId;
    private final Role role;
    private final String email;
    private final SocialType socialType;
    private final String nickname;
}
