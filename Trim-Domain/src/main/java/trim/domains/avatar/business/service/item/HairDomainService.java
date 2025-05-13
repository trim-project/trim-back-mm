package trim.domains.avatar.business.service.item;

import trim.domains.avatar.dao.entity.item.Hair;
import trim.domains.avatar.dao.entity.possessed.PossessedHair;
import trim.domains.member.dao.domain.Member;

public interface HairDomainService {
    PossessedHair purchaseHair(Member member, Hair hair);
}
