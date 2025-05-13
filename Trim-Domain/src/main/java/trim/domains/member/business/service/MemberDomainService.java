package trim.domains.member.business.service;

import trim.domains.member.dao.domain.Member;
import trim.domains.member.dao.domain.Profile;
import trim.domains.member.dao.domain.Role;

public interface MemberDomainService {
    Member registerMember(Profile profile, Role role, String nickname);

    Long convertNickname(String username, String nickname);

    void withdrawMember(String username);

    void getPoint(Member member, int point);


}
