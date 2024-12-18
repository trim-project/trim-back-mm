package trim.domains.member.service;

import trim.domains.member.domain.SocialType;

public interface MemberDomainService {
    Long registerMember(String username, String email, SocialType socialType);

    void withdrawMember(String username);

}
