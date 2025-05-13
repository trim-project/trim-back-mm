package trim.domains.avatar.business.service.item;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainService;
import trim.domains.avatar.dao.entity.item.Hair;
import trim.domains.avatar.dao.entity.possessed.PossessedHair;
import trim.domains.avatar.dao.repository.item.HairRepository;
import trim.domains.avatar.dao.repository.possessed.PossessedHairRepository;
import trim.domains.avatar.exception.AvatarHandler;
import trim.domains.member.dao.domain.Member;

@DomainService
@RequiredArgsConstructor
public class HairDomainServiceImpl implements HairDomainService {

    private final PossessedHairRepository possessedHairRepository;

    @Override
    public PossessedHair purchaseHair(Member member, Hair hair) {

        //포인트 관련 구매 로직 추가 예정입니다.

        PossessedHair possessedHair = PossessedHair.builder()
                .member(member)
                .hair(hair)
                .build();

        return possessedHairRepository.save(possessedHair);
    }
}
