package trim.api.domains.avatar.vo.response.parts;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class ClothPartsPossessedResponse {
    private final Long clothId;
    private final int price;
    private final String imageUrl;
    private final boolean purchased;
}
