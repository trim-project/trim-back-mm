package trim.domains.avatar.business.service.item;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainService;
import trim.domains.avatar.dao.entity.item.Mouth;
import trim.domains.avatar.dao.entity.possessed.PossessedMouth;
import trim.domains.avatar.dao.repository.item.MouthRepository;
import trim.domains.avatar.dao.repository.possessed.PossessedMouthRepository;
import trim.domains.member.dao.domain.Member;

@DomainService
@RequiredArgsConstructor
public class MouthDomainServiceImpl implements MouthDomainService{

    private final PossessedMouthRepository possessedMouthRepository;
    private final MouthRepository mouthRepository;

    @Override
    public PossessedMouth purchaseMouth(Member member, Long mouthId) {

        Mouth mouth = mouthRepository.findById(mouthId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Hair입니다.")); //예외처리 수정 예정입니다.

        //포인트 관련 구매 로직 추가 예정입니다.

        PossessedMouth possessedMouth = PossessedMouth.builder()
                .member(member)
                .mouth(mouth)
                .build();

        return possessedMouthRepository.save(possessedMouth);
    }
}
