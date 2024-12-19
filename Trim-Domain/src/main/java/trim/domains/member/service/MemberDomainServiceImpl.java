package trim.domains.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.DomainService;
import trim.domains.member.adaptor.MemberAdaptor;
import trim.domains.member.domain.Member;
import trim.domains.member.domain.Profile;
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
    public Long registerMember(Profile profile,Role role, String nickname) {
        memberValidator.checkCanRegister(profile.getUsername());
        Member newMember = Member.builder()
                .profile(profile)
                .role(role)
                .nickname(nickname)
                .build();
        return memberRepository.save(newMember).getId();
    }

    @Override
    public Long convertNickname(String username, String nickname) {
        Member member = memberAdaptor.queryMemberByUsername(username);
        memberValidator.checkCanConvertNickname(member);
        member.updateNickname(nickname);
        member.countConvertNicknameChance();
        return member.getId();
    }

    @Override
    public void withdrawMember(String username) {

    }
}
