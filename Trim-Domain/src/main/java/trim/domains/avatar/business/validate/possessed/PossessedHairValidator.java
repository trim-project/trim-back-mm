package trim.domains.avatar.business.validate.possessed;

import trim.domains.avatar.dao.entity.item.Hair;
import trim.domains.member.dao.domain.Member;

public interface PossessedHairValidator {
    void checkPossessedHairExists(Hair hair, Member member);
}
