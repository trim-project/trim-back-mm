package trim.api.domains.answer.vo;

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
public class AnswerDetailResponse {
    private final AnswerResponse answerResponse;
    private final MemberResponse memberResponse;
}
