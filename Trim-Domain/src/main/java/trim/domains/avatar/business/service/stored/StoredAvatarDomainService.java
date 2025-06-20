package trim.domains.avatar.business.service.stored;

import trim.domains.avatar.dto.StoredAvatarDto;
import trim.domains.member.dao.domain.Member;

public interface StoredAvatarDomainService {
    void storeAvatar(Member member, StoredAvatarDto dto);
}
