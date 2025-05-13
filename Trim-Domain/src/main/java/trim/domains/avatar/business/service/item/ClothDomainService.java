package trim.domains.avatar.business.service.item;

import trim.domains.avatar.dao.entity.item.Cloth;
import trim.domains.avatar.dao.entity.possessed.PossessedCloth;
import trim.domains.member.dao.domain.Member;

public interface ClothDomainService {
    PossessedCloth purchaseCloth(Member member, Cloth cloth);
}
