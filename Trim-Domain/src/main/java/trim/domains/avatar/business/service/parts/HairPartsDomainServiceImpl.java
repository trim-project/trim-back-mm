package trim.domains.avatar.business.service.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trim.domains.avatar.business.adaptor.parts.HairPartsAdaptor;
import trim.domains.avatar.dao.entity.enums.HairColor;
import trim.domains.avatar.dao.entity.parts.HairParts;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HairPartsDomainServiceImpl implements HairPartsDomainService {

    private final HairPartsAdaptor hairPartsAdaptor;

    @Override
    public List<HairParts> getHairPartsByColor(HairColor hairColor) {
        return hairPartsAdaptor.queryHairPartsByColor(hairColor);
    }
}
