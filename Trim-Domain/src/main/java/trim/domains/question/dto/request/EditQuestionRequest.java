package trim.domains.question.dto.request;

import lombok.Builder;
import lombok.Data;
import trim.domains.question.domain.Question;

@Data
@Builder
public class EditQuestionRequest {
    private String title;
    private String content;

}
