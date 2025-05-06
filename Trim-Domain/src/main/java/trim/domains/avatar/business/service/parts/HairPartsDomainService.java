package trim.domains.avatar.business.service.parts;

import trim.domains.avatar.dao.entity.enums.HairColor;
import trim.domains.avatar.dao.entity.parts.HairParts;

import java.util.List;

public interface HairPartsDomainService {
    List<HairParts> getHairPartsByColor(HairColor hairColor);
}
