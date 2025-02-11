package trim.domains.board.dto;

import lombok.Builder;
import lombok.Data;
import trim.domains.board.dao.domain.MajorType;

@Data
@Builder
public class KnowledgeDto {
    private String title;
    private String content;
    private MajorType majorType;
}
