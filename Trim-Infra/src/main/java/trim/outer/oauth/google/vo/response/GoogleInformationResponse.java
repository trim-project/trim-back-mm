package trim.outer.oauth.google.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class GoogleInformationResponse {
    private String id;
    private String email;
}
