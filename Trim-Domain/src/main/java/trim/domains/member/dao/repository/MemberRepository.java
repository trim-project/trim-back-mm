package trim.domains.member.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.member.dao.domain.Member;
import trim.domains.member.dao.domain.SocialType;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByProfileUsername(String username);

    Boolean existsByNickname(String nickname);

    Boolean existsByProfileUsername(String username);

    Optional<Member> findByNickname(String nickname);

    Optional<Member> findByProfileEmailAndProfileSocialType(String email, SocialType socialType);
}
