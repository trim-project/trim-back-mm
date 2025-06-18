package trim.domains.avatar.business.adaptor.item;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.avatar.dao.entity.item.Eyes;
import trim.domains.avatar.dao.repository.item.EyesRepository;
import trim.domains.avatar.exception.AvatarHandler;

@Adaptor
@RequiredArgsConstructor
public class EyesAdaptorImpl implements EyesAdaptor {

    private final EyesRepository eyesRepository;

    @Override
    public Eyes queryByEyesId(Long eyesId) {
        return eyesRepository.findById(eyesId)
                .orElseThrow(() -> AvatarHandler.AVATAR_EYES_NOT_FOUND);
    }
}
