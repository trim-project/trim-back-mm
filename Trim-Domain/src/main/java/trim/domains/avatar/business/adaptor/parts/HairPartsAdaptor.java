package trim.domains.avatar.business.adaptor.parts;

import trim.domains.avatar.dao.entity.enums.HairColor;
import trim.domains.avatar.dao.entity.parts.HairParts;

import java.util.List;

public interface HairPartsAdaptor {
    List<HairParts> queryHairPartsByColor(HairColor color);
}
