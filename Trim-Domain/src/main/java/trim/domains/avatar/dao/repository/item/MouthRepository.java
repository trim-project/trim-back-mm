package trim.domains.avatar.dao.repository.item;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.avatar.dao.entity.item.Mouth;
import trim.domains.avatar.dao.entity.enums.MouthAvatarNumber;

import java.util.Optional;

public interface MouthRepository extends JpaRepository<Mouth, Long> {
    Optional<Mouth> findByAvatarNumber(MouthAvatarNumber avatarNumber);
}
