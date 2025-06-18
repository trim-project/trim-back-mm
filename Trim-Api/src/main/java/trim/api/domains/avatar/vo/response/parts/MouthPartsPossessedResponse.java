package trim.api.domains.avatar.vo.response.parts;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.domains.avatar.dao.entity.enums.MouthForURL;

@Getter
@Builder
@RequiredArgsConstructor
public class MouthPartsPossessedResponse {
    private final Long mouthId;
    private final int price;
    private final String mouthForURL;
    private final boolean purchased;
}
