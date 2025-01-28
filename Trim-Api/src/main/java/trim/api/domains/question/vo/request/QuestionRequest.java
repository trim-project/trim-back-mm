package trim.api.domains.question.vo.request;

import lombok.Builder;
import lombok.Getter;
import trim.domains.board.dto.QuestionDto;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class QuestionRequest {
    private final String title;
    private final String content;
    @Builder.Default
    private final List<String> tags = new ArrayList<>();

    public QuestionDto from() {
        return QuestionDto.builder()
                .title(this.getTitle())
                .content(this.getContent())
                .build();
    }
}
