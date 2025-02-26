package trim.api.domains.knowledge.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class KnowledgeListResponse {
    @Builder.Default
    private final List<KnowledgeSummaryResponse> knowledgeResponseList = new ArrayList<>();
    private final int page;
    private final int totalPages;
}
