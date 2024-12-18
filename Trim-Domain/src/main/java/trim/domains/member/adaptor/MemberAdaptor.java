package trim.domains.member.adaptor;

import trim.domains.member.domain.Member;

public interface MemberAdaptor {

    Member queryMember(Long memberId);

    Member queryMemberByUsername(String username);

    Member queryMemberByNickname(String nickname);

}
