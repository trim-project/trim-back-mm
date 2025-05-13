package trim.api.domains.avatar.service.possessed;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.avatar.business.service.item.ClothDomainService;
import trim.domains.avatar.dao.entity.possessed.PossessedCloth;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;

@UseCase
@Transactional
@RequiredArgsConstructor
public class PurchaseClothUseCase {

    private final ClothDomainService clothDomainService;

    public Long execute(Member member, Long clothId) {
        PossessedCloth cloth = clothDomainService.purchaseCloth(member, clothId);
        return cloth.getId();
    }
}
