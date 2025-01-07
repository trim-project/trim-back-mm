package trim.domains.member.adaptor;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.Adaptor;
import trim.domains.member.domain.Member;
import trim.domains.member.exception.handler.MemberNotFoundException;
import trim.domains.member.repository.MemberRepository;

@Adaptor
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberAdaptorImpl implements MemberAdaptor {
    private final MemberRepository memberRepository;

    @Override
    public Member queryMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> MemberNotFoundException.EXCEPTION);
    }

    @Override
    public Member queryMemberByUsername(String username) {
        return memberRepository.findByProfileUsername(username)
                .orElseThrow(() -> MemberNotFoundException.EXCEPTION);
    }

    @Override
    public Member queryMemberByNickname(String nickname) {
        return memberRepository.findByNickname(nickname)
                .orElseThrow(() -> MemberNotFoundException.EXCEPTION);
    }

}
