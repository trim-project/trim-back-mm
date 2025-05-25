package trim.api.domains.avatar.service.possessed;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.avatar.business.adaptor.item.EyesAdaptor;
import trim.domains.avatar.business.adaptor.possessed.PossessedEyesAdaptor;
import trim.domains.avatar.business.service.item.EyesDomainService;
import trim.domains.avatar.dao.entity.item.Eyes;
import trim.domains.avatar.dao.entity.possessed.PossessedEyes;
import trim.domains.member.dao.domain.Member;

@UseCase
@Transactional
@RequiredArgsConstructor
public class PurchaseEyesUseCase {

    private final EyesDomainService eyesDomainService;
    private final EyesAdaptor eyesAdaptor;
    private final PossessedEyesAdaptor possessedEyesAdaptor;

    public Long execute(Member member, Long eyesId) {
        Eyes eyes = eyesAdaptor.queryByEyesId(eyesId);
        if(possessedEyesAdaptor.queryByPossessedEyesId(eyes, member)==null) {

        }
        PossessedEyes possessedEyes = eyesDomainService.purchaseEyes(member, eyes);
        return possessedEyes.getId();
    }
}
