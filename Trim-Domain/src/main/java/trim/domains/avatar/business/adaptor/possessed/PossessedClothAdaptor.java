package trim.domains.avatar.business.adaptor.possessed;

import trim.domains.avatar.dao.entity.item.Cloth;
import trim.domains.avatar.dao.entity.possessed.PossessedCloth;
import trim.domains.member.dao.domain.Member;

import java.util.List;

public interface PossessedClothAdaptor {
    List<PossessedCloth> queryByPossessedClothId(Cloth cloth, Member member);
}
