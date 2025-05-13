package trim.domains.avatar.business.adaptor.item;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.avatar.dao.entity.item.Hair;
import trim.domains.avatar.dao.repository.item.HairRepository;
import trim.domains.avatar.exception.AvatarHandler;

@Adaptor
@RequiredArgsConstructor
public class HairAdaptorImpl implements HairAdaptor {

    private final HairRepository hairRepository;

    @Override
    public Hair queryByHairId(Long hairid) {
        return hairRepository.findById(hairid)
                .orElseThrow(() -> AvatarHandler.AVATAR_HAIR_NOT_FOUND);}
}
