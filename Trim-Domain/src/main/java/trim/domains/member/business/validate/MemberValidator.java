package trim.domains.member.business.validate;

import trim.domains.member.dao.domain.Member;
import trim.domains.member.dao.domain.SocialType;

public interface MemberValidator {

    void checkCanRegister(String username);

    void checkCanConvertNickname(Member member);

    boolean isExistsByEmailAndProvider(String email, SocialType provider);
}
