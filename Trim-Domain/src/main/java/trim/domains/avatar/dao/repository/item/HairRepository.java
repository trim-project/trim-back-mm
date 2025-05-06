package trim.domains.avatar.dao.repository.item;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.avatar.dao.entity.item.Hair;
import trim.domains.avatar.dao.entity.enums.HairAvatarNumber;

import java.util.Optional;

public interface HairRepository extends JpaRepository<Hair, Long> {
    Optional<Hair> findByAvatarNumber(HairAvatarNumber avatarNumber);
}
