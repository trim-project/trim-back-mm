package trim.domains.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.DomainService;
import trim.domains.member.adaptor.MemberAdaptor;
import trim.domains.member.domain.Member;
import trim.domains.member.domain.Role;
import trim.domains.member.domain.SocialType;
import trim.domains.member.repository.MemberRepository;
import trim.domains.member.validate.MemberValidator;

@DomainService
@Transactional
@RequiredArgsConstructor
public class MemberDomainServiceImpl implements MemberDomainService {

    private final MemberRepository memberRepository;
    private final MemberAdaptor memberAdaptor;
    private final MemberValidator memberValidator;

    @Override
    public Long registerMember(String username, String email, SocialType socialType) {
        memberValidator.checkCanRegister(username);
        Member newMember = Member.builder()
                .role(Role.USER)
                .username(username)
                .email(email)
                .socialType(socialType)
                .build();
        return memberRepository.save(newMember).getId();
    }

    @Override
    public void withdrawMember(String username) {

    }
}
