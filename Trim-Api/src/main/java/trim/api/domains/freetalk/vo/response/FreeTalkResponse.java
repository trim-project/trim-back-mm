package trim.api.domains.freetalk.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class FreeTalkResponse {
    private final Long freeTalkId;
    private final String title;
    private final String content;
    private final Long createdAt;
}
