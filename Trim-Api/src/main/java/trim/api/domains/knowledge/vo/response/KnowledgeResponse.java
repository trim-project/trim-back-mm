package trim.api.domains.knowledge.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.domains.board.dao.domain.MajorType;

@Getter
@Builder
@RequiredArgsConstructor
public class KnowledgeResponse {

    private final Long knowledgeId;
    private final String title;
    private final String content;
    private final Long createdAt;
    private final MajorType majorType;
}
