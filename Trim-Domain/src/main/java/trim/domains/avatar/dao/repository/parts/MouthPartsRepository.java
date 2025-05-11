package trim.domains.avatar.dao.repository.parts;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.avatar.dao.entity.item.Mouth;
import trim.domains.avatar.dao.entity.parts.MouthParts;

import java.util.List;

public interface MouthPartsRepository extends JpaRepository<MouthParts, Long> {
    List<MouthParts> findAll();
}
