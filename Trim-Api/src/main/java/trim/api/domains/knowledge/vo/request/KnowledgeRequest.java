package trim.api.domains.knowledge.vo.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class KnowledgeRequest {
    private final String title;
    private final String content;
    private final String majorType;
    @Builder.Default
    private final List<String> tags = new ArrayList<>();
}
