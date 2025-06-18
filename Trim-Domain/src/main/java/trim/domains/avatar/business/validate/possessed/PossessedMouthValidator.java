package trim.domains.avatar.business.validate.possessed;

import trim.domains.avatar.dao.entity.item.Mouth;
import trim.domains.member.dao.domain.Member;

public interface PossessedMouthValidator {
    void checkPossessedMouthExists(Mouth mouth, Member member);
}
