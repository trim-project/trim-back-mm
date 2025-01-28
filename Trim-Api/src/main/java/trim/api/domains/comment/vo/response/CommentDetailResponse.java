package trim.api.domains.comment.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.api.domains.member.vo.MemberResponse;
import trim.domains.comment.dao.domain.Comment;

@Getter
@Builder
@RequiredArgsConstructor
public class CommentDetailResponse {
    private final CommentResponse commentResponse;
    private final MemberResponse memberResponse;
}
