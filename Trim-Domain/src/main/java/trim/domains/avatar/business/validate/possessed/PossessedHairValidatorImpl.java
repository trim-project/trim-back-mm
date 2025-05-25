package trim.domains.avatar.business.validate.possessed;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainValidator;
import trim.domains.avatar.dao.entity.item.Hair;
import trim.domains.avatar.dao.repository.possessed.PossessedHairRepository;
import trim.domains.avatar.exception.AvatarHandler;
import trim.domains.member.dao.domain.Member;

@DomainValidator
@RequiredArgsConstructor
public class PossessedHairValidatorImpl implements PossessedHairValidator{

    private final PossessedHairRepository possessedHairRepository;

    @Override
    public void checkPossessedHairExists(Hair hair, Member member) {
        if(possessedHairRepository.existsByHairAndMember(hair, member)) {
            throw AvatarHandler.AVATAR_ALREADY_PURCHASED_HAIR;
        }
    }
}
