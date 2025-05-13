package trim.api.domains.avatar.service.possessed;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.avatar.business.service.item.EyesDomainService;
import trim.domains.avatar.dao.entity.possessed.PossessedEyes;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;

@UseCase
@Transactional
@RequiredArgsConstructor
public class PurchaseEyesUseCase {

    private final EyesDomainService eyesDomainService;

    public Long execute(Member member, Long eyesId) {
        PossessedEyes eyes = eyesDomainService.purchaseEyes(member, eyesId);
        return eyes.getId();
    }
}
