package trim.domains.member.service;

import trim.domains.member.domain.Profile;
import trim.domains.member.domain.Role;
import trim.domains.member.domain.SocialType;

public interface MemberDomainService {
    Long registerMember(Profile profile, Role role, String nickname);

    Long convertNickname(String username, String nickname);

    void withdrawMember(String username);

}
