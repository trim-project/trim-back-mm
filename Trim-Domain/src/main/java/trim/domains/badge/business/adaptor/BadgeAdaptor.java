package trim.domains.badge.business.adaptor;

import trim.domains.badge.dao.entity.Badge;
import trim.domains.badge.dao.entity.BadgeContent;
import trim.domains.member.dao.domain.Member;

import java.util.List;

public interface BadgeAdaptor {

    List<Badge> queryAllBadge();

    Badge queryById(Long badgeId);

    List<Badge> queryCompletedBadgesByMember(Member member);

    List<Badge> queryBadgesByLevel(int level);

    Badge queryByContentAndLevel(BadgeContent badgeContent, int level);
}
