package trim.domains.avatar.business.service.item;

import trim.domains.avatar.dao.entity.possessed.PossessedMouth;
import trim.domains.member.dao.domain.Member;

public interface MouthDomainService {
    PossessedMouth purchaseMouth(Member member, Long mouthId);
}
