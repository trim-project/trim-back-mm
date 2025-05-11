package trim.api.domains.avatar.vo.response.parts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HairPartsResponse {
    private final Long hairId;
    private final int price;
    private final String imageUrl;
}

