package trim.api.domains.answer.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.domains.board.dto.AnswerDto;

@Getter
@Builder
@RequiredArgsConstructor
public class AnswerRequest {
    private final String title;
    private final String content;

    public AnswerDto from() {
        return AnswerDto.builder()
                .title(this.title)
                .content(this.content)
                .build();
    }
}
