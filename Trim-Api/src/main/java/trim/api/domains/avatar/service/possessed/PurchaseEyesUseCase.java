package trim.api.domains.avatar.service.possessed;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.avatar.business.adaptor.item.EyesAdaptor;
import trim.domains.avatar.business.adaptor.possessed.PossessedEyesAdaptor;
import trim.domains.avatar.business.service.item.EyesDomainService;
import trim.domains.avatar.business.validate.possessed.PossessedEyesValidator;
import trim.domains.avatar.dao.entity.item.Eyes;
import trim.domains.avatar.dao.entity.possessed.PossessedEyes;
import trim.domains.avatar.exception.AvatarHandler;
import trim.domains.member.dao.domain.Member;
import trim.domains.member.exception.MemberHandler;

@RequiredArgsConstructor
@UseCase
@Transactional
public class PurchaseEyesUseCase {

    private final EyesAdaptor eyesAdaptor;
    private final PossessedEyesValidator possessedEyesValidator;
    private final EyesDomainService eyesDomainService;

    public Long execute(Member member, Long eyesId) {
        Eyes eyes = eyesAdaptor.queryByEyesId(eyesId);

        possessedEyesValidator.checkPossessedEyesExists(eyes, member);

        if (member.getPoint() < eyes.getPrice()) {
            throw MemberHandler.MEMBER_NOT_ENOUGH_POINT;
        }

        member.usePoint(eyes.getPrice());
        PossessedEyes possessedEyes = eyesDomainService.purchaseEyes(member, eyes);
        return possessedEyes.getId();
    }
}

