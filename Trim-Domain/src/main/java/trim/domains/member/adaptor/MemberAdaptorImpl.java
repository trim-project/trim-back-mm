package trim.domains.member.adaptor;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.Adaptor;
import trim.domains.member.domain.Member;
import trim.domains.member.repository.MemberRepository;

@Adaptor
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberAdaptorImpl implements MemberAdaptor {
    private final MemberRepository memberRepository;

    @Override
    public Member queryMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("not found member"));
    }

    @Override
    public Member queryMemberByUsername(String username) {
        return memberRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("not found member"));
    }

    @Override
    public Member queryMemberByNickname(String nickname) {
        return memberRepository.findByNickname(nickname)
                .orElseThrow(() -> new RuntimeException("not found member"));
    }

}
