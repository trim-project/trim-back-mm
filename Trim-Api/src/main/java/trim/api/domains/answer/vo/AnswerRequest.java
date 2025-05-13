package trim.api.domains.answer.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.domains.board.dto.AnswerDto;

@Getter
@Builder
public class AnswerRequest {
    private final String content;

    @JsonCreator
    public AnswerRequest(@JsonProperty("content") String content) {
        this.content = content;
    }


    public AnswerDto from() {
        return AnswerDto.builder()
                .content(this.content)
                .build();
    }
}
