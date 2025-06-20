package trim.domains.avatar.business.service.stored;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainService;
import trim.domains.avatar.dto.StoredAvatarDto;
import trim.domains.member.dao.domain.Avatar;
import trim.domains.member.dao.domain.Member;

@DomainService
@RequiredArgsConstructor
public class StoredAvatarDomainServiceImpl implements StoredAvatarDomainService {

    @Override
    public void storeAvatar(Member member, StoredAvatarDto dto) {
        Avatar avatar = Avatar.builder()
                .backgroundColor(dto.getBackgroundColor())
                .clothForURL(dto.getClothForURL())
                .eyesForURL(dto.getEyesForURL())
                .hairForURL(dto.getHairForURL())
                .mouthForURL(dto.getMouthForURL())
                .build();

        member.setAvatar(avatar);
    }
}
