package trim.domains.mission.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.badge.dao.entity.Badge;
import trim.domains.member.dao.domain.Member;
import trim.domains.mission.dao.entity.Mission;

import java.util.Optional;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Optional<Mission> findByBadgeAndMember(Badge badge, Member member);

    Optional<Mission> findByBadgeIdAndMemberId(Long badgeId, Long memberId);
}
