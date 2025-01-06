package trim.domains.member.validate;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.DomainValidator;
import trim.common.exception.ErrorStatus;
import trim.common.exception.MemberHandler;
import trim.domains.member.domain.Member;
import trim.domains.member.repository.MemberRepository;

@DomainValidator
@RequiredArgsConstructor
public class MemberValidatorImpl implements MemberValidator{
    private final MemberRepository memberRepository;

    @Override
    public void checkCanRegister(String username) {
        if (!memberRepository.existsByNickname(username)) {
            throw new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND);
        }
    }

    @Override
    public void checkCanConvertNickname(Member member) {
        if (member.getNicknameChangeChance() == 0) {
            throw new MemberHandler(ErrorStatus.MEMBER_HAVE_ANY_CHANCE_OF_CONVERT_NICKNAME);
        }
    }
}
