package trim.api.domains.question.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.api.domains.comment.vo.response.CommentResponse;
import trim.api.domains.member.vo.MemberResponse;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class QuestionDetailResponse {
    private final QuestionResponse questionResponse;
    private final MemberResponse memberResponse;
    @Builder.Default
    private final List<CommentResponse> commentResponseList = new ArrayList<>();

}
