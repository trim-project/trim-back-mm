package trim.domains.member.business.adaptor;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.Adaptor;
import trim.domains.member.dao.domain.Member;
import trim.domains.member.exception.MemberHandler;
import trim.domains.member.dao.repository.MemberRepository;

import java.util.List;

@Adaptor
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberAdaptorImpl implements MemberAdaptor {
    private final MemberRepository memberRepository;

    @Override
    public Member queryMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> MemberHandler.NOT_FOUND);
    }

    @Override
    public Member queryMemberByUsername(String username) {
        return memberRepository.findByProfileUsername(username)
                .orElseThrow(() -> MemberHandler.NOT_FOUND);
    }

    @Override
    public Member queryMemberByNickname(String nickname) {
        return memberRepository.findByNickname(nickname)
                .orElseThrow(() -> MemberHandler.NOT_FOUND);
    }

    @Override
    public List<Member> queryAllMember() {
        return memberRepository.findAll();
    }

}
