package trim.api.domains.question.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.api.domains.member.vo.MemberResponse;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class QuestionSummaryResponse {

    private final QuestionResponse questionResponse;
    private final MemberResponse memberResponse;
    private final Long likeCount;
    private final Long answerCount;
    @Builder.Default
    private final List<String> tagList = new ArrayList<>();
}
