package trim.api.member.service;

import lombok.RequiredArgsConstructor;
import trim.api.member.vo.MemberRequest;
import trim.common.annotation.UseCase;
import trim.domains.member.service.MemberDomainService;

@UseCase
@RequiredArgsConstructor
public class RegisterMemberUseCase {
    private final MemberDomainService memberDomainService;

    public Long execute(MemberRequest memberRequest) {

        return memberDomainService.registerMember();
    }
}
