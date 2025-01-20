package trim.domains.board.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FreeTalkDto {
    private final String title;
    private final String content;
}
