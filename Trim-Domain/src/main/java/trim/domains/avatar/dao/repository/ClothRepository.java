package trim.domains.avatar.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.avatar.dao.entity.Cloth;

public interface ClothRepository extends JpaRepository<Cloth, Long> {
}
