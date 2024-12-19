package trim.domains.member.validate;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.DomainValidator;
import trim.domains.member.repository.MemberRepository;

@DomainValidator
@RequiredArgsConstructor
public class MemberValidatorImpl implements MemberValidator{
    private final MemberRepository memberRepository;

    @Override
    public Boolean checkCanRegister(String username) {
        return memberRepository.existsByNickname(username);
    }

    @Override
    public Boolean checkCanConvertNickname(String nickname) {
        return memberRepository.existsByNickname(nickname);
    }
}
