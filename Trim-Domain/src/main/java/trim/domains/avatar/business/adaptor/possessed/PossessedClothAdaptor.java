package trim.domains.avatar.business.adaptor.possessed;

import trim.domains.avatar.dao.entity.possessed.PossessedCloth;
import trim.domains.member.dao.domain.Member;

public interface PossessedClothAdaptor {
    PossessedCloth queryByPossessedClothId(Long ClothId, Member member);
}
