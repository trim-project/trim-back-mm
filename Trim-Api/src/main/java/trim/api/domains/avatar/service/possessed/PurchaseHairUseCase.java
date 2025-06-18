package trim.api.domains.avatar.service.possessed;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.avatar.business.adaptor.item.HairAdaptor;
import trim.domains.avatar.business.adaptor.possessed.PossessedHairAdaptor;
import trim.domains.avatar.business.service.item.HairDomainService;
import trim.domains.avatar.business.validate.item.HairValidator;
import trim.domains.avatar.business.validate.possessed.PossessedHairValidator;
import trim.domains.avatar.dao.entity.item.Hair;
import trim.domains.avatar.dao.entity.possessed.PossessedHair;
import trim.domains.avatar.exception.AvatarHandler;
import trim.domains.member.dao.domain.Member;
import trim.domains.member.exception.MemberHandler;

@UseCase
@Transactional
@RequiredArgsConstructor
public class PurchaseHairUseCase {

    private final HairDomainService hairDomainService;
    private final HairAdaptor hairAdaptor;
    private final PossessedHairValidator possessedHairValidator;

    public Long execute(Member member, Long hairId) {
        Hair hair = hairAdaptor.queryByHairId(hairId);

        possessedHairValidator.checkPossessedHairExists(hair, member);

        if (member.getPoint() < hair.getPrice()) {
            throw MemberHandler.MEMBER_NOT_ENOUGH_POINT;
        }

        member.usePoint(hair.getPrice());
        PossessedHair possessedHair = hairDomainService.purchaseHair(member, hair);
        return possessedHair.getId();
    }
}

