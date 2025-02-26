package trim.api.domains.freetalk.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class FreeTalkListResponse {
    @Builder.Default
    private final List<FreeTalkSummaryResponse> freeTalkResponseList = new ArrayList<>();
    private final int page;
    private final int totalPages;
}
