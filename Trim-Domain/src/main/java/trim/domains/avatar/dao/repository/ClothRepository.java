package trim.domains.avatar.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.avatar.dao.entity.Cloth;
import trim.domains.avatar.dao.entity.enums.ClothAvatarNumber;

import java.util.Optional;

public interface ClothRepository extends JpaRepository<Cloth, Long> {
    Optional<Cloth> findByAvatarNumber(ClothAvatarNumber avatarNumber);
}
