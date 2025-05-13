package trim.api.domains.avatar.service.possessed;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.avatar.business.service.item.MouthDomainService;
import trim.domains.avatar.dao.entity.possessed.PossessedMouth;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;

@UseCase
@Transactional
@RequiredArgsConstructor
public class PurchaseMouthUseCase {

    private final MouthDomainService mouthDomainService;

    public Long execute(Member member, Long mouthId) {
        PossessedMouth mouth = mouthDomainService.purchaseMouth(member, mouthId);
        return mouth.getId();
    }
}
