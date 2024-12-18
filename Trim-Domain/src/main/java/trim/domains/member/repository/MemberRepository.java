package trim.domains.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.member.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUsername(String username);

    Boolean existsByNickname(String nickname);

    Boolean existsByUsername(String username);

    Optional<Member> findByNickname(String nickname);
}
