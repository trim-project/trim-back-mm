package trim.domains.avatar.business.adaptor.parts;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.avatar.dao.entity.enums.ClothColor;
import trim.domains.avatar.dao.entity.parts.ClothParts;
import trim.domains.avatar.dao.repository.parts.ClothPartsRepository;

import java.util.List;

@Adaptor
@RequiredArgsConstructor
public class ClothPartsAdaptorImpl implements ClothPartsAdaptor{
    private final ClothPartsRepository clothPartsRepository;

    @Override
    public List<ClothParts> queryClothPartsByColor(ClothColor color) {
        return clothPartsRepository.findAllByClothColor(color);
    }
}
