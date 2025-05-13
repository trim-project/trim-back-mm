package trim.api.domains.avatar.service.possessed;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.avatar.business.adaptor.item.ClothAdaptor;
import trim.domains.avatar.business.service.item.ClothDomainService;
import trim.domains.avatar.dao.entity.item.Cloth;
import trim.domains.avatar.dao.entity.possessed.PossessedCloth;
import trim.domains.member.dao.domain.Member;

@UseCase
@Transactional
@RequiredArgsConstructor
public class PurchaseClothUseCase {

    private final ClothDomainService clothDomainService;
    private final ClothAdaptor clothAdaptor;

    public Long execute(Member member, Long clothId) {
        Cloth cloth = clothAdaptor.queryByClothId(clothId);
        PossessedCloth possessedCloth = clothDomainService.purchaseCloth(member, cloth);
        return possessedCloth.getId();
    }
}
