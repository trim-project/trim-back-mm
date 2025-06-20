package trim.domains.mission.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.badge.dao.entity.BadgeContent;
import trim.domains.member.dao.domain.Member;
import trim.domains.mission.dao.entity.Mission;

import java.util.List;
import java.util.Optional;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Optional<Mission> findByBadgeAndMember(Badge badge, Member member);

    Optional<Mission> findByBadgeIdAndMemberId(Long badgeId, Long memberId);

    @Query("SELECT m FROM Mission m " +
            "JOIN m.badge b " +
            "WHERE m.member = :member " +
            "AND b.badgeContent = :badgeContent")
    List<Mission> findByMemberAndBadgeContent(@Param("member") Member member,
                                              @Param("badgeContent") BadgeContent badgeContent);

    List<Mission> findByMemberId(Long memberId);

    long countByMemberAndIsSelectedBadgeTrue(Member member);
}
