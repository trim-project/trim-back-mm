package trim.domains.avatar.business.adaptor.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import trim.domains.avatar.dao.entity.enums.HairColor;
import trim.domains.avatar.dao.entity.parts.HairParts;
import trim.domains.avatar.dao.repository.parts.HairPartsRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HairPartsAdaptorImpl implements HairPartsAdaptor {

    private final HairPartsRepository hairPartsRepository;

    @Override
    public List<HairParts> queryHairPartsByColor(HairColor color) {
        return hairPartsRepository.findAllByHairColor(color);
    }
}
