package trim.api.domains.avatar.service.stored;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.avatar.vo.request.stored.StoredAvatarRequest;
import trim.common.annotation.UseCase;
import trim.domains.avatar.business.service.stored.StoredAvatarDomainService;
import trim.domains.member.dao.domain.Member;

@UseCase
@Transactional
@RequiredArgsConstructor
public class StoredAvatarUseCase {

    private final StoredAvatarDomainService storedAvatarDomainService;

    public Long execute(Member member, StoredAvatarRequest request) {
        storedAvatarDomainService.storeAvatar(member, request.from());
        return member.getId();
    }

}
