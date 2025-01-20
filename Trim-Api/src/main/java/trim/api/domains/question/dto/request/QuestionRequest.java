package trim.api.domains.question.dto.request;

import lombok.Builder;
import lombok.Getter;
import trim.domains.board.dto.QuestionDto;

@Getter
@Builder
public class QuestionRequest {
    private final String title;
    private final String content;

    public QuestionDto from() {
        return QuestionDto.builder()
                .title(this.getTitle())
                .content(this.getContent())
                .build();
    }
}
