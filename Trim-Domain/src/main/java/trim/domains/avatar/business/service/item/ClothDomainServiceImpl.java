package trim.domains.avatar.business.service.item;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainService;
import trim.domains.avatar.dao.entity.item.Cloth;
import trim.domains.avatar.dao.entity.possessed.PossessedCloth;
import trim.domains.avatar.dao.repository.item.ClothRepository;
import trim.domains.avatar.dao.repository.possessed.PossessedClothRepository;
import trim.domains.member.dao.domain.Member;

@DomainService
@RequiredArgsConstructor
public class ClothDomainServiceImpl implements ClothDomainService {

    private final PossessedClothRepository possessedClothRepository;
    private final ClothRepository clothRepository;

    @Override
    public PossessedCloth purchaseCloth(Member member, Long clothId) {

        Cloth cloth = clothRepository.findById(clothId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Cloth입니다.")); //예외처리 수정 예정입니다.

        //포인트 관련 구매 로직 추가 예정입니다.

        PossessedCloth possessedCloth = PossessedCloth.builder()
                .member(member)
                .cloth(cloth)
                .build();

        return possessedClothRepository.save(possessedCloth);
    }
}
