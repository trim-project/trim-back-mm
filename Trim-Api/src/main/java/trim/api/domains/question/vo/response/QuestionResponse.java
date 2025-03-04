package trim.api.domains.question.vo.response;

import lombok.Builder;
import lombok.Getter;
import trim.domains.board.dao.domain.MajorType;
import trim.domains.board.dao.domain.ResolveStatus;


@Getter
@Builder
public class QuestionResponse {
    private final Long questionId;
    private final String title;
    private final String content;
    private final Long createdAt;
    private final ResolveStatus resolveStatus;
    private final MajorType majorType;
}
