package trim.domains.badge.business.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainService;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.badge.dao.entity.BadgeContent;
import trim.domains.badge.dao.repository.BadgeRepository;

@DomainService
@RequiredArgsConstructor
public class BadgeDomainServiceImpl implements BadgeDomainService{

    private final BadgeRepository badgeRepository;

    @Override
    public Badge createBadge(String title, BadgeContent badgeContent, int goal) {
        Badge newBadge = Badge.builder()
                .badgeTitle(title)
                .badgeContent(badgeContent)
                .goal(goal)
                .build();
        return badgeRepository.save(newBadge);
    }

    @Override
    public void addNextBadge(Badge badge, Long nextBadgeId) {
        badge.addNextBadge(nextBadgeId);
    }
}
