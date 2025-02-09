package trim.api.domains.freetalk.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.api.domains.member.vo.MemberResponse;

import java.time.LocalDate;

@Getter
@Builder
@RequiredArgsConstructor
public class FreeTalkSummaryResponse {
    private final FreeTalkResponse freeTalkResponse;
    private final MemberResponse memberResponse;
    private Long likeCount;
//    private boolean isLiked; TODO
    private Long commentCount;

}
