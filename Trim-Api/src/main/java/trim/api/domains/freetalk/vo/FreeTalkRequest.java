package trim.api.domains.freetalk.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class FreeTalkRequest {

    private final String title;
    private final String content;
}
