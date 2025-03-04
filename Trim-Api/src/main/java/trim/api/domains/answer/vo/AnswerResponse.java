package trim.api.domains.answer.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class AnswerResponse {
    private final String title;
    private final String content;
    private final Long questionId;
    private final Long createdAt;
}
