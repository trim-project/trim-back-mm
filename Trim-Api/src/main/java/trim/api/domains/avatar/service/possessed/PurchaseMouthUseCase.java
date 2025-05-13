package trim.api.domains.avatar.service.possessed;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.avatar.business.adaptor.item.MouthAdaptor;
import trim.domains.avatar.business.service.item.MouthDomainService;
import trim.domains.avatar.dao.entity.item.Mouth;
import trim.domains.avatar.dao.entity.possessed.PossessedMouth;
import trim.domains.member.dao.domain.Member;

@UseCase
@Transactional
@RequiredArgsConstructor
public class PurchaseMouthUseCase {

    private final MouthDomainService mouthDomainService;
    private final MouthAdaptor mouthAdaptor;

    public Long execute(Member member, Long mouthId) {
        Mouth mouth = mouthAdaptor.queryByMouthId(mouthId);
        PossessedMouth possessedMouth = mouthDomainService.purchaseMouth(member, mouth);
        return possessedMouth.getId();
    }
}
