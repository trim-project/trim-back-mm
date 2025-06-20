package trim.api.domains.avatar.vo.response.stored;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.domains.avatar.dao.entity.enums.BackgroundColor;

@Getter
@Builder
@RequiredArgsConstructor
public class StoredAvatarResponse {
    private final BackgroundColor backgroundColor;
    private final String clothForURL;
    private final String eyesForURL;
    private final String hairForURL;
    private final String mouthForURL;
}
