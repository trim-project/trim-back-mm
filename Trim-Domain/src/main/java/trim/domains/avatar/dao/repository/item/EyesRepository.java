package trim.domains.avatar.dao.repository.item;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.avatar.dao.entity.item.Eyes;
import trim.domains.avatar.dao.entity.enums.EyesAvatarNumber;

import java.util.Optional;

public interface EyesRepository extends JpaRepository<Eyes, Long> {
    Optional<Eyes> findByAvatarNumber(EyesAvatarNumber avatarNumber);
}
