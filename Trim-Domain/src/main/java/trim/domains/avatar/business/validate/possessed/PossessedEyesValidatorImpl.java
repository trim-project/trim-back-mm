package trim.domains.avatar.business.validate.possessed;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainValidator;
import trim.domains.avatar.dao.entity.item.Eyes;
import trim.domains.avatar.dao.repository.possessed.PossessedEyesRepository;
import trim.domains.avatar.exception.AvatarHandler;
import trim.domains.member.dao.domain.Member;

@DomainValidator
@RequiredArgsConstructor
public class PossessedEyesValidatorImpl implements PossessedEyesValidator{

    private final PossessedEyesRepository possessedEyesRepository;

    @Override
    public void checkPossessedEyesExists(Eyes eyes, Member member) {
        if(possessedEyesRepository.existsByEyesAndMember(eyes, member)) {
            throw AvatarHandler.AVATAR_ALREADY_PURCHASED_EYES;
        }
    }
}
