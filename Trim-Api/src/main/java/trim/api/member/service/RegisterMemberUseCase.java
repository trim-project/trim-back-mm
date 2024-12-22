package trim.api.member.service;

import lombok.RequiredArgsConstructor;
import trim.api.member.mapper.MemberMapper;
import trim.api.member.vo.MemberRequest;
import trim.common.annotation.UseCase;
import trim.domains.member.domain.Profile;
import trim.domains.member.domain.Role;
import trim.domains.member.service.MemberDomainService;

@UseCase
@RequiredArgsConstructor
public class RegisterMemberUseCase {

    private final MemberDomainService memberDomainService;

    public Long execute(MemberRequest memberRequest) {
        Profile profile = MemberMapper.INSTANCE.toProfile(memberRequest);
        return memberDomainService.registerMember(
                profile,
                Role.converter(memberRequest.getRole()),
                memberRequest.getNickname()
        );
    }
}
