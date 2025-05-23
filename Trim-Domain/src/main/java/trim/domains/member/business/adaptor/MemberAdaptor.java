package trim.domains.member.business.adaptor;

import trim.domains.member.dao.domain.Member;
import trim.domains.member.dao.domain.SocialType;

import java.util.List;

public interface MemberAdaptor {

    Member queryMember(Long memberId);

    Member queryMemberByUsername(String username);

    Member queryMemberByNickname(String nickname);

    List<Member> queryAllMember();

    Member queryMemberByEmailAndProvider(String email, SocialType socialType);
}
