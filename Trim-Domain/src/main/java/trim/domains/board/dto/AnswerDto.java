package trim.domains.board.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerDto {
    private String title;
    private String content;
}
