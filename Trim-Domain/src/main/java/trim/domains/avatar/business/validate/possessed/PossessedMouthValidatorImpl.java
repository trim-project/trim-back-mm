package trim.domains.avatar.business.validate.possessed;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainValidator;
import trim.domains.avatar.dao.entity.item.Mouth;
import trim.domains.avatar.dao.repository.possessed.PossessedMouthRepository;
import trim.domains.avatar.exception.AvatarHandler;
import trim.domains.member.dao.domain.Member;

@DomainValidator
@RequiredArgsConstructor
public class PossessedMouthValidatorImpl implements PossessedMouthValidator{

    private final PossessedMouthRepository possessedMouthRepository;

    @Override
    public void checkPossessedMouthExists(Mouth mouth, Member member) {
        if(possessedMouthRepository.existsByMouthAndMember(mouth, member)) {
            throw AvatarHandler.AVATAR_ALREADY_PURCHASED_MOUTH;
        }
    }
}
