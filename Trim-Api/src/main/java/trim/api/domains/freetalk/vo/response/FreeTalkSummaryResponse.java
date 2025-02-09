package trim.api.domains.freetalk.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.api.domains.member.vo.MemberResponse;

@Getter
@Builder
@RequiredArgsConstructor
public class FreeTalkSummaryResponse {
    private final FreeTalkResponse freeTalkResponse;
    private final MemberResponse memberResponse;
    private final Long likeCount;
//    private boolean isLiked; TODO
    private final Long commentCount;

}
