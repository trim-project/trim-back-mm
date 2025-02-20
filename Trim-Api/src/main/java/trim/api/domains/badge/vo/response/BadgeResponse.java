package trim.api.domains.badge.vo.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.domains.badge.dao.entity.BadgeContent;

@Getter
@RequiredArgsConstructor
public class BadgeResponse {
    private final Long badgeId;
    private final BadgeContent badgeContent;
    private final int level;
    private final String badgeTitle;
    private final int goal;
}
