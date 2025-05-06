package trim.domains.avatar.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.avatar.dao.entity.Hair;

public interface HairRepository extends JpaRepository<Hair, Long> {
}
