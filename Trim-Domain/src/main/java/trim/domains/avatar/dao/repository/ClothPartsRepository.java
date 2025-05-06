package trim.domains.avatar.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.avatar.dao.entity.ClothParts;

public interface ClothPartsRepository extends JpaRepository<ClothParts, Long> {
}
