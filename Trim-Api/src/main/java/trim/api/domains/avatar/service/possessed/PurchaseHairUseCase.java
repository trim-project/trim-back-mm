package trim.api.domains.avatar.service.possessed;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.avatar.business.service.item.HairDomainService;
import trim.domains.avatar.dao.entity.possessed.PossessedHair;
import trim.domains.member.dao.domain.Member;

@UseCase
@Transactional
@RequiredArgsConstructor
public class PurchaseHairUseCase {

    private final HairDomainService hairDomainService;

    public Long execute(Member member, Long hairId) {
        PossessedHair hair = hairDomainService.purchaseHair(member, hairId);
        return hair.getId();
    }
}

