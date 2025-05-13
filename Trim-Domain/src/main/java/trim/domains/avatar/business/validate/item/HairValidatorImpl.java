package trim.domains.avatar.business.validate.item;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainValidator;
import trim.domains.avatar.dao.entity.item.Hair;
import trim.domains.avatar.dao.repository.item.HairRepository;
import trim.domains.avatar.exception.AvatarHandler;

@DomainValidator
@RequiredArgsConstructor
public class HairValidatorImpl implements HairValidator {
    private final HairRepository hairRepository;

    @Override
    public void checkHairExists(Hair hair) {
        if(!hairRepository.existsById(hair.getId())) {
            throw AvatarHandler.AVATAR_HAIR_NOT_FOUND;
        }
    }
}
