package trim.domains.board.dto;

import lombok.Builder;
import lombok.Data;
import trim.domains.board.dao.domain.MajorType;

@Data
@Builder
public class QuestionDto {
    private final String title;
    private final String content;
    private final MajorType majorType;
}
