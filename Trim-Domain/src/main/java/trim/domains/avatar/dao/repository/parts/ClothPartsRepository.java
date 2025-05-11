package trim.domains.avatar.dao.repository.parts;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.avatar.dao.entity.enums.ClothColor;
import trim.domains.avatar.dao.entity.parts.ClothParts;
import trim.domains.avatar.dao.entity.parts.HairParts;

import java.util.List;

public interface ClothPartsRepository extends JpaRepository<ClothParts, Long> {
    List<ClothParts> findAllByClothColor(ClothColor color);
}
