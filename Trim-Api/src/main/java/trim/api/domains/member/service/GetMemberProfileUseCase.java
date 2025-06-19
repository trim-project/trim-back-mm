package trim.api.domains.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.member.vo.response.MemberProfileResponse;
import trim.common.annotation.UseCase;
import trim.domains.member.business.service.MemberDomainService;
import trim.domains.member.dao.domain.Member;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetMemberProfileUseCase {

    public MemberProfileResponse execute(Member member) {
        return MemberProfileResponse.builder()
                .memberId(member.getId())
                .name(member.getName())
                .nickname(member.getNickname())
                .description(member.getDescription())
                .major(member.getMajor())
                .university(member.getUniversity())
                .build();
    }
}
