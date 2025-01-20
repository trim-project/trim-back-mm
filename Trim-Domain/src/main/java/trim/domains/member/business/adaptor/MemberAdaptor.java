package trim.domains.member.business.adaptor;

import trim.domains.member.dao.domain.Member;

public interface MemberAdaptor {

    Member queryMember(Long memberId);

    Member queryMemberByUsername(String username);

    Member queryMemberByNickname(String nickname);

}
