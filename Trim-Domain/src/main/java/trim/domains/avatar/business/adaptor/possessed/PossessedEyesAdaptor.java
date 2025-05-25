package trim.domains.avatar.business.adaptor.possessed;

import trim.domains.avatar.dao.entity.possessed.PossessedEyes;
import trim.domains.member.dao.domain.Member;

public interface PossessedEyesAdaptor {
    PossessedEyes queryByPossessedEyesId(Long EyesId, Member member);
}
