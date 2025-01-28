package trim.domains.tag.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.tag.dao.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
