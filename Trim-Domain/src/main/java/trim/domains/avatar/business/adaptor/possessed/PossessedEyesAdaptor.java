package trim.domains.avatar.business.adaptor.possessed;

import trim.domains.avatar.dao.entity.item.Eyes;
import trim.domains.avatar.dao.entity.possessed.PossessedEyes;
import trim.domains.member.dao.domain.Member;

import java.util.List;

public interface PossessedEyesAdaptor {
    List<PossessedEyes> queryByPossessedEyesId(Eyes eyes, Member member);

}
