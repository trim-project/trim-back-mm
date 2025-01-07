package trim.domains.member.validate;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainValidator;
import trim.domains.member.domain.Member;
import trim.domains.member.exception.handler.HaveAnyChanceOfConvertNicknameException;
import trim.domains.member.exception.handler.MemberNotFoundException;
import trim.domains.member.repository.MemberRepository;

@DomainValidator
@RequiredArgsConstructor
public class MemberValidatorImpl implements MemberValidator{
    private final MemberRepository memberRepository;

    @Override
    public void checkCanRegister(String username) {
        if (!memberRepository.existsByNickname(username)) {
            throw MemberNotFoundException.EXCEPTION;
        }
    }

    @Override
    public void checkCanConvertNickname(Member member) {
        if (member.getNicknameChangeChance() == 0) {
            throw HaveAnyChanceOfConvertNicknameException.EXCEPTION;
        }
    }
}
