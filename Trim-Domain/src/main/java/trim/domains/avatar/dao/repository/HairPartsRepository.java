package trim.domains.avatar.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.avatar.dao.entity.HairParts;

public interface HairPartsRepository extends JpaRepository<HairParts, Long> {
}
