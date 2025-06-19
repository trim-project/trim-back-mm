package trim.api.domains.avatar.service.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.avatar.mapper.parts.ClothPartsMapper;
import trim.api.domains.avatar.vo.response.parts.ClothPartsResponse;
import trim.common.annotation.UseCase;
import trim.domains.avatar.business.adaptor.parts.ClothPartsAdaptor;
import trim.domains.avatar.dao.entity.enums.ClothColor;
import trim.domains.avatar.dao.entity.parts.ClothParts;

import java.util.List;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetClothPartsUseCase {

    private final ClothPartsAdaptor clothPartsAdaptor;

    public List<ClothPartsResponse> execute(ClothColor clothColor) {
        List<ClothParts> parts = clothPartsAdaptor.queryClothPartsByColor(clothColor);
        return parts.stream()
                .map(part -> new ClothPartsResponse(
                        part.getCloth().getId(),
                        part.getCloth().getPrice(),
                        part.getImageUrl().getKey()
                ))
                .toList();
    }
}
