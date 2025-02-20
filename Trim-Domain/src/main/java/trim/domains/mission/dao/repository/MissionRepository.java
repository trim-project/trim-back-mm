package trim.domains.mission.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.mission.dao.entity.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
