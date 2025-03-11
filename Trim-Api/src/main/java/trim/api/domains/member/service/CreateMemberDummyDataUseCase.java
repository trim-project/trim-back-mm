package trim.api.domains.member.service;

import lombok.RequiredArgsConstructor;
import trim.api.domains.member.vo.request.MemberRequest;
import trim.common.annotation.UseCase;
import trim.domains.member.dao.domain.Role;
import trim.domains.member.dao.domain.SocialType;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class CreateMemberDummyDataUseCase {

    private final RegisterMemberUseCase registerMemberUseCase;

    public boolean execute(int memberCount) {
        for (int i = 0; i < memberCount; i++) {
            MemberRequest request = MemberRequest.builder()
                    .email(UUID.randomUUID().toString() + "@trim.com")
                    .role(Role.USER.getKey())
                    .socialType(SocialType.TRIM.getKey())
                    .username(UUID.randomUUID().toString() + i)
                    .nickname(UUID.randomUUID().toString() + i)
                    .build();
            registerMemberUseCase.execute(request);
        }
        return true;
    }
}
