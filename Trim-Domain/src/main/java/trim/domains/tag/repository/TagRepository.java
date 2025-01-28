package trim.domains.tag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.tag.dao.entity.Tag;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findByName(String name);
}
