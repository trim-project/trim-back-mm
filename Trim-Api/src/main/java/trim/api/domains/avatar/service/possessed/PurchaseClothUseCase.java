package trim.api.domains.avatar.service.possessed;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.avatar.business.adaptor.item.ClothAdaptor;
import trim.domains.avatar.business.adaptor.possessed.PossessedClothAdaptor;
import trim.domains.avatar.business.service.item.ClothDomainService;
import trim.domains.avatar.business.validate.possessed.PossessedClothValidator;
import trim.domains.avatar.dao.entity.item.Cloth;
import trim.domains.avatar.dao.entity.possessed.PossessedCloth;
import trim.domains.avatar.exception.AvatarHandler;
import trim.domains.member.dao.domain.Member;
import trim.domains.member.exception.MemberHandler;

@UseCase
@Transactional
@RequiredArgsConstructor
public class PurchaseClothUseCase {

    private final ClothDomainService clothDomainService;
    private final ClothAdaptor clothAdaptor;
    private final PossessedClothValidator possessedClothValidator;

    public Long execute(Member member, Long clothId) {
        Cloth cloth = clothAdaptor.queryByClothId(clothId);

        possessedClothValidator.checkPossessedClothExists(cloth, member);

        if (member.getPoint() < cloth.getPrice()) {
            throw MemberHandler.MEMBER_NOT_ENOUGH_POINT;
        }

        member.usePoint(cloth.getPrice());
        PossessedCloth possessedCloth = clothDomainService.purchaseCloth(member, cloth);
        return possessedCloth.getId();
    }
}
