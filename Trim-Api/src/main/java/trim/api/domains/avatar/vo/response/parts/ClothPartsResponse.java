package trim.api.domains.avatar.vo.response.parts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.domains.avatar.dao.entity.enums.ClothColor;

@Getter
@RequiredArgsConstructor
public class ClothPartsResponse {
    private final Long clothId;
    private final int price;
    private final String imageUrl;
}
