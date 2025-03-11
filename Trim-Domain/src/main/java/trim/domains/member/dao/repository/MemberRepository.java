package trim.domains.member.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import trim.domains.member.dao.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByProfileUsername(@Param("username") String username);

    Boolean existsByNickname(String nickname);

    Boolean existsByProfileUsername(String username);

    Optional<Member> findByNickname(String nickname);
}
