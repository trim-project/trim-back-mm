package trim.domains.avatar.business.service.item;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainService;
import trim.domains.avatar.dao.entity.item.Eyes;
import trim.domains.avatar.dao.entity.possessed.PossessedEyes;
import trim.domains.avatar.dao.repository.item.EyesRepository;
import trim.domains.avatar.dao.repository.possessed.PossessedEyesRepository;
import trim.domains.avatar.exception.AvatarHandler;
import trim.domains.member.dao.domain.Member;

@DomainService
@RequiredArgsConstructor
public class EyesDomainServiceImpl implements EyesDomainService {

    private final PossessedEyesRepository possessedEyesRepository;
    private final EyesRepository eyesRepository;

    @Override
    public PossessedEyes purchaseEyes(Member member, Eyes eyes) {

        //포인트 관련 구매 로직 추가 예정입니다.

        PossessedEyes possessedEyes = PossessedEyes.builder()
                .member(member)
                .eyes(eyes)
                .build();

        return possessedEyesRepository.save(possessedEyes);
    }
}
