package trim.domains.badge.business.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainService;
import trim.domains.badge.dao.repository.BadgeRepository;

@DomainService
@RequiredArgsConstructor
public class BadgeDomainServiceImpl implements BadgeDomainService{

    private final BadgeRepository badgeRepository;
}
