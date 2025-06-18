package trim.api.domains.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.member.vo.request.MemberProfileRequest;
import trim.common.annotation.UseCase;
import trim.domains.member.business.service.MemberDomainService;
import trim.domains.member.dao.domain.Member;
import trim.domains.member.dto.MemberProfileDto;

@UseCase
@Transactional
@RequiredArgsConstructor
public class PatchMemberProfileUseCase {

    private final MemberDomainService memberDomainService;
    public Long execute(Member member, MemberProfileRequest memberProfileRequest) {
        MemberProfileDto dto = MemberProfileDto.builder()
                .description(memberProfileRequest.getDescription())
                .major(memberProfileRequest.getMajor())
                .university(memberProfileRequest.getUniversity())
                .name(memberProfileRequest.getName())
                .nickname(memberProfileRequest.getNickname())
                .build();
        return memberDomainService.updateProfile(member, dto);
    }
}
