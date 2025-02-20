package trim.domains.badge.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.badge.dao.entity.BadgeContent;
import trim.domains.member.dao.domain.Member;

import java.util.List;
import java.util.Optional;

public interface BadgeRepository extends JpaRepository<Badge, Long> {
    @Query("SELECT DISTINCT m.badge FROM Mission m " +
            "WHERE m.member = :member")
    List<Badge> findBadgesByMember(@Param("member") Member member);

    boolean existsByBadgeTitle(String badgeTitle);

    @Query("SELECT b.badgeTitle FROM Badge b")
    List<String> findAllBadgeTitles();

    List<Badge> findByLevel(int level);

    Optional<Badge> findByBadgeContentAndLevel(BadgeContent badgeContent, int level);
}
