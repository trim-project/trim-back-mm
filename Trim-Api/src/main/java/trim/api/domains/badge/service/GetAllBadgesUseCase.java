package trim.api.domains.badge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.badge.mapper.BadgeMapper;
import trim.api.domains.badge.vo.response.BadgeResponse;
import trim.common.annotation.UseCase;
import trim.domains.badge.business.adaptor.BadgeAdaptor;
import trim.domains.badge.dao.entity.Badge;

import java.util.List;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetAllBadgesUseCase {

    private final BadgeAdaptor badgeAdaptor;

    public List<BadgeResponse> execute() {
        List<Badge> badges = badgeAdaptor.queryAllBadge();
        return badges.stream()
                .map(BadgeMapper.INSTANCE::toResponseBadge)
                .toList();
    }
}
