package trim.api.domains.avatar.vo.response.parts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EyesPartsResponse {
    private final Long eyesId;
    private final int price;
    private final String imageUrl;
}
