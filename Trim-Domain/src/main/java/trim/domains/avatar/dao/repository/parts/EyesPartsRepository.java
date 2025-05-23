package trim.domains.avatar.dao.repository.parts;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.avatar.dao.entity.parts.EyesParts;

import java.util.List;

public interface EyesPartsRepository extends JpaRepository<EyesParts, Long> {
    List<EyesParts> findAll();
}
