package trim.domains.member.business.validate;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainValidator;
import trim.domains.member.dao.domain.Member;
import trim.domains.member.exception.MemberHandler;
import trim.domains.member.dao.repository.MemberRepository;

@DomainValidator
@RequiredArgsConstructor
public class MemberValidatorImpl implements MemberValidator{
    private final MemberRepository memberRepository;

    @Override
    public void checkCanRegister(String username) {
        if (!memberRepository.existsByNickname(username)) {
            throw MemberHandler.NOT_FOUND;
        }
    }

    @Override
    public void checkCanConvertNickname(Member member) {
        if (member.getNicknameChangeChance() == 0) {
            throw MemberHandler.HAVE_ANY_CHANCE_OF_CONVERT_NICKNAME;
        }
    }
}
