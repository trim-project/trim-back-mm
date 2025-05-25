package trim.domains.avatar.business.adaptor.possessed;

import trim.domains.avatar.dao.entity.possessed.PossessedHair;
import trim.domains.member.dao.domain.Member;

public interface PossessedHairAdaptor {
    PossessedHair queryByPossessedHairId(Long hairId, Member member);
}
