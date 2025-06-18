package trim.domains.avatar.business.validate.possessed;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainValidator;
import trim.domains.avatar.dao.entity.item.Cloth;
import trim.domains.avatar.dao.repository.possessed.PossessedClothRepository;
import trim.domains.avatar.exception.AvatarHandler;
import trim.domains.member.dao.domain.Member;

@DomainValidator
@RequiredArgsConstructor
public class PossessedClothValidatorImpl implements PossessedClothValidator{

    private final PossessedClothRepository possessedClothRepository;

    @Override
    public void checkPossessedClothExists(Cloth cloth, Member member) {
        if(possessedClothRepository.existsByClothAndMember(cloth, member)) {
            throw AvatarHandler.AVATAR_ALREADY_PURCHASED_CLOTH;
        }
    }
}
