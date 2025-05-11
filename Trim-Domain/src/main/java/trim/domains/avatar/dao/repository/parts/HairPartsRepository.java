package trim.domains.avatar.dao.repository.parts;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.avatar.dao.entity.enums.HairColor;
import trim.domains.avatar.dao.entity.parts.HairParts;

import java.util.List;

public interface HairPartsRepository extends JpaRepository<HairParts, Long> {
    List<HairParts> findAllByHairColor(HairColor color);
}
