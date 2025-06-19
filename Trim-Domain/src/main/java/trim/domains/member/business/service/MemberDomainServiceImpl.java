package trim.domains.member.business.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.DomainService;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;
import trim.domains.member.dao.domain.Profile;
import trim.domains.member.dao.domain.Role;
import trim.domains.member.dao.repository.MemberRepository;
import trim.domains.member.dto.MemberProfileDto;

@DomainService
@Transactional
@RequiredArgsConstructor
public class MemberDomainServiceImpl implements MemberDomainService {

    private final MemberRepository memberRepository;
    private final MemberAdaptor memberAdaptor;

    @Override
    public Member registerMember(Profile profile, Role role, String nickname) {
        Member newMember = Member.builder()
                .profile(profile)
                .role(role)
                .nickname(nickname)
                .nicknameChangeChance(1)
                .build();
        return memberRepository.save(newMember);
    }

    @Override
    public Long convertNickname(String username, String nickname) {
        Member member = memberAdaptor.queryMemberByUsername(username);
        member.updateNickname(nickname);
        member.countConvertNicknameChance();
        return member.getId();
    }

    @Override
    public void withdrawMember(String username) {

    }

    @Override
    public void getPoint(Member member, int point) {
        member.updatePoint(point);
    }

    @Override
    public Long updateProfile(Member member, MemberProfileDto dto) {
        member.updateProfileInfo(dto);
        return member.getId();
    }
}
