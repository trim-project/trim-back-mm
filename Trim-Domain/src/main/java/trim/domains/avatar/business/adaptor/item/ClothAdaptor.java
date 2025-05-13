package trim.domains.avatar.business.adaptor.item;

import trim.domains.avatar.dao.entity.item.Cloth;

import java.util.List;

public interface ClothAdaptor {
    Cloth queryByClothId(Long clothId);
}
