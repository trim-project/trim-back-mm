package trim.api.domains.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import trim.api.domains.member.mapper.MemberMapper;
import trim.api.domains.member.vo.MemberRequest;
import trim.common.annotation.UseCase;
import trim.domains.member.domain.Profile;
import trim.domains.member.domain.Role;
import trim.domains.member.service.MemberDomainService;

@Slf4j
@UseCase
@RequiredArgsConstructor
public class RegisterMemberUseCase {

    private final MemberDomainService memberDomainService;

    public Long execute(MemberRequest memberRequest) {
        Profile profile = MemberMapper.INSTANCE.toProfile(memberRequest);
        log.info("profile email = {}", profile.getEmail());
        log.info("profile username = {}", profile.getUsername());
        log.info("profile socialType = {}", profile.getSocialType());
        return memberDomainService.registerMember(
                profile,
                Role.converter(memberRequest.getRole()),
                memberRequest.getNickname()
        );
    }
}
