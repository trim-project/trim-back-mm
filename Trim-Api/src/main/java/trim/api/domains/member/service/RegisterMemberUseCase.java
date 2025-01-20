package trim.api.domains.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import trim.api.domains.member.mapper.MemberMapper;
import trim.api.domains.member.vo.MemberRequest;
import trim.common.annotation.UseCase;
import trim.common.util.EnumConvertUtil;
import trim.domains.member.dao.domain.Profile;
import trim.domains.member.dao.domain.Role;
import trim.domains.member.business.service.MemberDomainService;

@Slf4j
@UseCase
@RequiredArgsConstructor
public class RegisterMemberUseCase {

    private final MemberDomainService memberDomainService;

    public Long execute(MemberRequest memberRequest) {
        Profile profile = MemberMapper.INSTANCE.toProfile(memberRequest);
        return memberDomainService.registerMember(
                profile,
                EnumConvertUtil.convert(Role.class, memberRequest.getRole()),
                memberRequest.getNickname()
        );
    }
}
