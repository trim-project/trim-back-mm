package trim.domains.badge.business.adaptor;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.badge.dao.entity.BadgeContent;
import trim.domains.badge.dao.repository.BadgeRepository;
import trim.domains.badge.exception.BadgeHandler;
import trim.domains.member.dao.domain.Member;

import java.util.List;

@Adaptor
@RequiredArgsConstructor
public class BadgeAdaptorImpl implements BadgeAdaptor{

    private final BadgeRepository badgeRepository;

    @Override
    public List<Badge> queryAllBadge() {
        return badgeRepository.findAll();
    }

    @Override
    public Badge queryById(Long badgeId) {
        return badgeRepository.findById(badgeId)
                .orElseThrow(() -> BadgeHandler.NOT_FOUND);
    }

    @Override
    public List<Badge> queryCompletedBadgesByMember(Member member) {
        return badgeRepository.findBadgesByMember(member);
    }

    @Override
    public List<Badge> queryBadgesByLevel(int level) {
        return badgeRepository.findByLevel(level);
    }

    @Override
    public Badge queryByContentAndLevel(BadgeContent badgeContent, int level) {
        return badgeRepository.findByBadgeContentAndLevel(badgeContent, level)
                .orElseThrow(() -> BadgeHandler.NOT_FOUND);
    }
}
