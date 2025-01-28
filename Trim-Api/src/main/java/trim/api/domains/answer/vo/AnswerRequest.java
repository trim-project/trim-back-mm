package trim.api.domains.answer.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class AnswerRequest {
    private final String title;
    private final String content;
}
