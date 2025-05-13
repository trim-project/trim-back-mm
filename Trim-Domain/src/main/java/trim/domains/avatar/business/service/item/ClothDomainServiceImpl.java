package trim.domains.avatar.business.service.item;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainService;
import trim.domains.avatar.dao.entity.item.Cloth;
import trim.domains.avatar.dao.entity.possessed.PossessedCloth;
import trim.domains.avatar.dao.repository.item.ClothRepository;
import trim.domains.avatar.dao.repository.possessed.PossessedClothRepository;
import trim.domains.avatar.exception.AvatarHandler;
import trim.domains.member.dao.domain.Member;

@DomainService
@RequiredArgsConstructor
public class ClothDomainServiceImpl implements ClothDomainService {

    private final PossessedClothRepository possessedClothRepository;

    @Override
    public PossessedCloth purchaseCloth(Member member, Cloth cloth) {

        PossessedCloth possessedCloth = PossessedCloth.builder()
                .member(member)
                .cloth(cloth)
                .build();

        return possessedClothRepository.save(possessedCloth);
    }
}
