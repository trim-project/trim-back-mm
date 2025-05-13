package trim.domains.avatar.business.service.item;

import trim.domains.avatar.dao.entity.possessed.PossessedEyes;
import trim.domains.member.dao.domain.Member;

public interface EyesDomainService {
    PossessedEyes purchaseEyes(Member member, Long eyesId);
}
