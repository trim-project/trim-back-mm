package trim.domains.member.validate;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.DomainValidator;
import trim.domains.member.domain.Member;
import trim.domains.member.repository.MemberRepository;

@DomainValidator
@RequiredArgsConstructor
public class MemberValidatorImpl implements MemberValidator{
    private final MemberRepository memberRepository;

    @Override
    public void checkCanRegister(String username) {
        if (!memberRepository.existsByNickname(username)) {
            throw new RuntimeException("not found user");
        }
    }

    @Override
    public void checkCanConvertNickname(Member member) {
        if (member.getNicknameChangeChance() == 0) {
            throw new RuntimeException("have any chance");
        }
    }
}
