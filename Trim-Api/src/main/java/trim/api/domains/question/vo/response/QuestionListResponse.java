package trim.api.domains.question.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class QuestionListResponse {
    @Builder.Default
    private final List<QuestionSummaryResponse> questionResponseList = new ArrayList<>();
    private final int page;
    private final int totalPages;
}
