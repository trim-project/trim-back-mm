package trim.domains.avatar.business.adaptor.possessed;

import trim.domains.avatar.dao.entity.possessed.PossessedMouth;
import trim.domains.member.dao.domain.Member;

public interface PossessedMouthAdaptor {
    PossessedMouth queryByPossessedMouthId(Long MouthId, Member member);
}
