package trim.domains.avatar.business.adaptor.item;

import trim.domains.avatar.dao.entity.item.Hair;

public interface HairAdaptor {
    Hair queryByHairId(Long hairId);
}
