package trim.api.domains.avatar.service.stored;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.avatar.vo.response.stored.StoredAvatarResponse;
import trim.common.annotation.UseCase;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;

@UseCase
@Transactional
@RequiredArgsConstructor
public class GetStoredAvatarUseCase {

    public StoredAvatarResponse execute(Member member) {
        return StoredAvatarResponse.builder()
                .backgroundColor(member.getAvatar().getBackgroundColor())
                .clothForURL(member.getAvatar().getClothForURL())
                .eyesForURL(member.getAvatar().getEyesForURL())
                .hairForURL(member.getAvatar().getHairForURL())
                .mouthForURL(member.getAvatar().getMouthForURL())
                .build();
    }
}
