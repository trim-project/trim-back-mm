package trim.domains.avatar.business.adaptor.parts;

import trim.domains.avatar.dao.entity.enums.ClothColor;
import trim.domains.avatar.dao.entity.parts.ClothParts;

import java.util.List;

public interface ClothPartsAdaptor {
    List<ClothParts> queryClothPartsByColor(ClothColor color);
}
