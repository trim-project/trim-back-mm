package trim.domains.avatar.dto;

import lombok.Builder;
import lombok.Data;
import trim.domains.avatar.dao.entity.enums.*;

@Data
@Builder
public class StoredAvatarDto {
    private final BackgroundColor backgroundColor;
    private final String clothForURL;
    private final String eyesForURL;
    private final String hairForURL;
    private final String mouthForURL;
}
