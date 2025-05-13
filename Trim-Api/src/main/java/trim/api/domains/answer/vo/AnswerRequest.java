package trim.api.domains.answer.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.domains.board.dto.AnswerDto;

@Getter
@Builder
@RequiredArgsConstructor
public class AnswerRequest {
    private final String content;

    public AnswerDto from() {
        return AnswerDto.builder()
                .content(this.content)
                .build();
    }
}
