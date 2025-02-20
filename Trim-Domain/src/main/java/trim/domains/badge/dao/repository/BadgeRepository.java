package trim.domains.badge.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.member.dao.domain.Member;

import java.util.List;

public interface BadgeRepository extends JpaRepository<Badge, Long> {
    @Query("SELECT DISTINCT m.badge FROM Mission m " +
            "WHERE m.member = :member")
    List<Badge> findBadgesByMember(@Param("member") Member member);
}
