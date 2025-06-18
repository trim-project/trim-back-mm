package trim.domains.avatar.business.validate.possessed;

import trim.domains.avatar.dao.entity.item.Cloth;
import trim.domains.member.dao.domain.Member;

public interface PossessedClothValidator {
    void checkPossessedClothExists(Cloth cloth, Member member);
}
