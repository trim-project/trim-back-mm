package trim.domains.badge.business.service;

import trim.domains.badge.dao.entity.Badge;
import trim.domains.badge.dao.entity.BadgeContent;

public interface BadgeDomainService {

    Badge createBadge(String title, BadgeContent badgeContent, int goal);
}
