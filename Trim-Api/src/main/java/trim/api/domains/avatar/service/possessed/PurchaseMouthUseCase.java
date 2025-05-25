package trim.api.domains.avatar.service.possessed;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.avatar.business.adaptor.item.MouthAdaptor;
import trim.domains.avatar.business.adaptor.possessed.PossessedMouthAdaptor;
import trim.domains.avatar.business.service.item.MouthDomainService;
import trim.domains.avatar.business.validate.possessed.PossessedMouthValidator;
import trim.domains.avatar.dao.entity.item.Mouth;
import trim.domains.avatar.dao.entity.possessed.PossessedMouth;
import trim.domains.avatar.exception.AvatarHandler;
import trim.domains.member.dao.domain.Member;
import trim.domains.member.exception.MemberHandler;

@UseCase
@Transactional
@RequiredArgsConstructor
public class PurchaseMouthUseCase {

    private final MouthDomainService mouthDomainService;
    private final MouthAdaptor mouthAdaptor;
    private final PossessedMouthValidator possessedMouthValidator;

    public Long execute(Member member, Long mouthId) {
        Mouth mouth = mouthAdaptor.queryByMouthId(mouthId);

        possessedMouthValidator.checkPossessedMouthExists(mouth, member);

        if(member.getPoint() < mouth.getPrice()) {
            throw MemberHandler.MEMBER_NOT_ENOUGH_POINT;
        }

        member.usePoint(mouth.getPrice());
        PossessedMouth possessedMouth = mouthDomainService.purchaseMouth(member, mouth);
        return possessedMouth.getId();
    }
}
