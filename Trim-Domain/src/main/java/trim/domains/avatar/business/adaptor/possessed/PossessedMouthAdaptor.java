package trim.domains.avatar.business.adaptor.possessed;

import trim.domains.avatar.dao.entity.item.Mouth;
import trim.domains.avatar.dao.entity.possessed.PossessedMouth;
import trim.domains.member.dao.domain.Member;

public interface PossessedMouthAdaptor {
    PossessedMouth queryByPossessedMouthId(Mouth mouth, Member member);
}
