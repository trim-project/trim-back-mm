package trim.api.domains.avatar.service.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.avatar.mapper.parts.HairPartsMapper;
import trim.api.domains.avatar.vo.response.parts.HairPartsResponse;
import trim.common.annotation.UseCase;
import trim.domains.avatar.business.adaptor.parts.HairPartsAdaptor;
import trim.domains.avatar.dao.entity.enums.HairColor;
import trim.domains.avatar.dao.entity.parts.HairParts;

import java.util.List;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetHairPartsUseCase {

    private final HairPartsAdaptor hairPartsAdaptor;

    public List<HairPartsResponse> execute(HairColor hairColor) {
        List<HairParts> parts = hairPartsAdaptor.queryHairPartsByColor(hairColor);
        return parts.stream()
                .map(part-> new HairPartsResponse(
                        part.getHair().getId(),
                        part.getHair().getPrice(),
                        part.getImageUrl().getKey()
                ))
                .toList();
    }
}

