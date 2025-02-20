package trim.domains.badge.business.adaptor;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.badge.dao.repository.BadgeRepository;

@Adaptor
@RequiredArgsConstructor
public class BadgeAdaptorImpl implements BadgeAdaptor{

    private final BadgeRepository badgeRepository;
}
