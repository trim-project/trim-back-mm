package trim.api.domains.avatar.vo.response.parts;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.domains.avatar.dao.entity.enums.ClothForURL;

@Getter
@Builder
@RequiredArgsConstructor
public class ClothPartsPossessedResponse {
    private final Long clothId;
    private final int price;
    private final String clothForURL;
    private final boolean purchased;
}
