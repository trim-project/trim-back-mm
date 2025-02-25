package trim.api.domains.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.member.mapper.MemberMapper;
import trim.api.domains.member.vo.MemberRequest;
import trim.common.annotation.UseCase;
import trim.common.util.EnumConvertUtil;
import trim.domains.badge.business.adaptor.BadgeAdaptor;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.member.business.service.MemberDomainService;
import trim.domains.member.dao.domain.Member;
import trim.domains.member.dao.domain.Profile;
import trim.domains.member.dao.domain.Role;
import trim.domains.member.dao.domain.SocialType;
import trim.domains.mission.business.service.MissionDomainService;
import trim.domains.mission.dao.entity.MissionStatus;

import java.util.List;
import java.util.UUID;

import static trim.domains.mission.dao.entity.MissionStatus.IN_PROGRESS;
import static trim.domains.mission.dao.entity.MissionStatus.LOCKED;

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
