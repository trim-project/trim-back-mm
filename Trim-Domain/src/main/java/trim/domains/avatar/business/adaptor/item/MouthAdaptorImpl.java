package trim.domains.avatar.business.adaptor.item;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.avatar.dao.entity.item.Mouth;
import trim.domains.avatar.dao.repository.item.MouthRepository;
import trim.domains.avatar.exception.AvatarHandler;

@Adaptor
@RequiredArgsConstructor
public class MouthAdaptorImpl implements MouthAdaptor {

    private final MouthRepository mouthRepository;

    @Override
    public Mouth queryByMouthId(Long mouthId) {
        return mouthRepository.findById(mouthId)
                .orElseThrow(() -> AvatarHandler.AVATAR_MOUTH_NOT_FOUND);
    }
}
