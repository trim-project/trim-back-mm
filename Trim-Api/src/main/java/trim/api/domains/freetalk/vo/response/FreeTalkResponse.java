package trim.api.domains.freetalk.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@RequiredArgsConstructor
public class FreeTalkResponse {
    private final Long freeTalkId;
    private final String title;
    private final String content;
    private final LocalDate createdAt;
}
