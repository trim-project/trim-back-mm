package trim.domains.avatar.business.service.item;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainService;
import trim.domains.avatar.dao.entity.item.Mouth;
import trim.domains.avatar.dao.entity.possessed.PossessedMouth;
import trim.domains.avatar.dao.repository.possessed.PossessedMouthRepository;
import trim.domains.member.dao.domain.Member;

@DomainService
@RequiredArgsConstructor
public class MouthDomainServiceImpl implements MouthDomainService{

    private final PossessedMouthRepository possessedMouthRepository;

    @Override
    public PossessedMouth purchaseMouth(Member member, Mouth mouth) {

        PossessedMouth possessedMouth = PossessedMouth.builder()
                .member(member)
                .mouth(mouth)
                .build();

        return possessedMouthRepository.save(possessedMouth);
    }
}
