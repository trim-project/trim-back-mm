package trim.domains.avatar.business.adaptor.possessed;

import trim.domains.avatar.dao.entity.item.Mouth;
import trim.domains.avatar.dao.entity.possessed.PossessedMouth;
import trim.domains.member.dao.domain.Member;

import java.util.List;

public interface PossessedMouthAdaptor {
    List<PossessedMouth> queryByPossessedMouthId(Mouth mouth, Member member);
    List<PossessedMouth> queryByMember(Member member);
}
