package trim.domains.avatar.business.validate.possessed;

import trim.domains.avatar.dao.entity.item.Eyes;
import trim.domains.member.dao.domain.Member;

public interface PossessedEyesValidator {
    void checkPossessedEyesExists(Eyes eyes, Member member);
}
