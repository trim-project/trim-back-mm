package trim.domains.avatar.business.adaptor.item;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.avatar.dao.entity.item.Cloth;
import trim.domains.avatar.dao.repository.item.ClothRepository;
import trim.domains.avatar.exception.AvatarHandler;

import java.util.List;

@Adaptor
@RequiredArgsConstructor
public class ClothAdaptorImpl implements ClothAdaptor{

    private final ClothRepository clothRepository;

    @Override
    public Cloth queryByClothId(Long clothId) {
        return clothRepository.findById(clothId)
                .orElseThrow(() -> AvatarHandler.AVATAR_CLOTH_NOT_FOUND);
    }
}
