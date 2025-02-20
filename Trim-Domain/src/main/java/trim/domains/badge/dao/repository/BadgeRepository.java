package trim.domains.badge.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.badge.dao.entity.Badge;

public interface BadgeRepository extends JpaRepository<Badge, Long> {
}
