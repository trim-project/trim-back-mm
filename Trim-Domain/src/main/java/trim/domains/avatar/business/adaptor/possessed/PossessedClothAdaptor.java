package trim.domains.avatar.business.adaptor.possessed;

import trim.domains.avatar.dao.entity.item.Cloth;
import trim.domains.avatar.dao.entity.possessed.PossessedCloth;
import trim.domains.member.dao.domain.Member;

public interface PossessedClothAdaptor {
    PossessedCloth queryByPossessedClothId(Cloth cloth, Member member);
}
