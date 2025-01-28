package trim.api.domains.freetalk.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.api.domains.comment.vo.response.CommentDetailResponse;
import trim.api.domains.comment.vo.response.CommentResponse;
import trim.api.domains.member.vo.MemberResponse;
import trim.domains.board.dao.repository.FreeTalkRepository;

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
}
