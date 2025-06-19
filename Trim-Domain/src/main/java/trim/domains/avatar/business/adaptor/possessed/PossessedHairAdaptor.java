package trim.domains.avatar.business.adaptor.possessed;

import trim.domains.avatar.dao.entity.item.Hair;
import trim.domains.avatar.dao.entity.possessed.PossessedHair;
import trim.domains.member.dao.domain.Member;

import java.util.List;

public interface PossessedHairAdaptor {
    List<PossessedHair> queryByPossessedHairId(Hair hair, Member member);
    List<PossessedHair> queryByMember(Member member);
}
