package trim.domains.badge.business.service;

import trim.domains.badge.dao.entity.Badge;

public interface BadgeDomainService {

    Badge createBadge(String title, int goal);

    void addNextBadge(Badge badge, Long nextBadgeId);
}
