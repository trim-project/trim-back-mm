package trim.api.domains.avatar.vo.request.stored;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.domains.avatar.dao.entity.enums.*;
import trim.domains.avatar.dto.StoredAvatarDto;

@Getter
@Builder
@RequiredArgsConstructor
public class StoredAvatarRequest {

    private final BackgroundColor backgroundColor;
    private final String clothForURL;
    private final String eyesForURL;
    private final String hairForURL;
    private final String mouthForURL;

    public StoredAvatarDto from() {
        return StoredAvatarDto.builder()
                .backgroundColor(this.backgroundColor)
                .clothForURL(this.clothForURL)
                .eyesForURL(this.eyesForURL)
                .hairForURL(this.hairForURL)
                .mouthForURL(this.mouthForURL)
                .build();

    }

}
