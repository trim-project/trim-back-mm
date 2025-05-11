package trim.api.domains.avatar.vo.response.parts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MouthPartsResponse {
    private final Long mouthId;
    private final int price;
    private final String imageUrl;
}
