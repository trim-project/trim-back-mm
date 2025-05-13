package trim.domains.avatar.business.service.item;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainService;
import trim.domains.avatar.dao.entity.item.Hair;
import trim.domains.avatar.dao.entity.possessed.PossessedHair;
import trim.domains.avatar.dao.repository.item.HairRepository;
import trim.domains.avatar.dao.repository.possessed.PossessedHairRepository;
import trim.domains.member.dao.domain.Member;

@DomainService
@RequiredArgsConstructor
public class HairDomainServiceImpl implements HairDomainService {

    private final PossessedHairRepository possessedHairRepository;
    private final HairRepository hairRepository;

    @Override
    public PossessedHair purchaseHair(Member member, Long hairId) {

        Hair hair = hairRepository.findById(hairId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Hair입니다.")); //예외처리 수정 예정입니다.

        //포인트 관련 구매 로직 추가 예정입니다.

        PossessedHair possessedHair = PossessedHair.builder()
                .member(member)
                .hair(hair)
                .build();

        return possessedHairRepository.save(possessedHair);
    }
}
