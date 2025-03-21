package trim.api.domains.freetalk.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.api.domains.comment.vo.response.CommentDetailResponse;
import trim.api.domains.freetalk.mapper.FreeTalkMapper;
import trim.api.domains.member.mapper.MemberMapper;
import trim.api.domains.member.vo.response.MemberResponse;
import trim.domains.board.dao.domain.FreeTalk;
import trim.domains.comment.dao.domain.Comment;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class FreeTalkDetailResponse {
    private final FreeTalkResponse freeTalkResponse;
    private final MemberResponse memberResponse;
    @Builder.Default
    private final List<CommentDetailResponse> commentDetailResponseList = new ArrayList<>();

    public static FreeTalkDetailResponse of(FreeTalk freeTalk, List<Comment> comments) {
        return FreeTalkDetailResponse.builder()
                .freeTalkResponse(FreeTalkMapper.INSTANCE.toFreeTalkResponse(freeTalk))
                .memberResponse(MemberMapper.INSTANCE.toMemberResponse(freeTalk.getWriter()))
                .commentDetailResponseList(comments.stream().map(CommentDetailResponse::of).toList())
                .build();
    }
}
