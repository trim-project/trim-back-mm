package trim.domains.avatar.business.adaptor.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import trim.domains.avatar.dao.entity.enums.ClothColor;
import trim.domains.avatar.dao.entity.item.Cloth;
import trim.domains.avatar.dao.entity.parts.ClothParts;
import trim.domains.avatar.dao.repository.parts.ClothPartsRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClothPartsAdaptorImpl implements ClothPartsAdaptor{
    private final ClothPartsRepository clothPartsRepository;

    @Override
    public List<ClothParts> queryClothPartsByColor(ClothColor color) {
        return clothPartsRepository.findAllByClothColor(color);
    }
}
