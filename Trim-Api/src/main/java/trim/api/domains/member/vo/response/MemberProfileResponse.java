package trim.api.domains.member.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class MemberProfileResponse {
    private final Long memberId;
    private final String name;
    private final String nickname;
    private final String major;
    private final String university;
    private final String description;
}
