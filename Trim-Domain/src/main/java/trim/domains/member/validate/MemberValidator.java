package trim.domains.member.validate;

import trim.domains.member.domain.Member;

public interface MemberValidator {

    void checkCanRegister(String username);

    void checkCanConvertNickname(Member member);
}
