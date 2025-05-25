package trim.domains.avatar.business.adaptor.item;

import trim.domains.avatar.dao.entity.item.Cloth;


public interface ClothAdaptor {
    Cloth queryByClothId(Long clothId);
}
