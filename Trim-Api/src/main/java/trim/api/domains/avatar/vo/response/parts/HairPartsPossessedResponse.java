package trim.api.domains.avatar.vo.response.parts;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.domains.avatar.dao.entity.enums.HairForURL;

@Getter
@Builder
@RequiredArgsConstructor
public class HairPartsPossessedResponse {
    private final Long hairId;
    private final int price;
    private final String hairForURL;
    private final boolean purchased;
}
