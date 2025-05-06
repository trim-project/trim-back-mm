package trim.domains.avatar.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.avatar.dao.entity.Mouth;
import trim.domains.avatar.dao.entity.enums.MouthAvatarNumber;

import java.util.Optional;

public interface MouthRepository extends JpaRepository<Mouth, Long> {
    Optional<Mouth> findByAvatarNumber(MouthAvatarNumber avatarNumber);
}
