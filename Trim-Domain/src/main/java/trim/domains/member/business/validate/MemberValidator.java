package trim.domains.member.business.validate;

import trim.domains.member.dao.domain.Member;

public interface MemberValidator {

    void checkCanRegister(String username);

    void checkCanConvertNickname(Member member);
}
