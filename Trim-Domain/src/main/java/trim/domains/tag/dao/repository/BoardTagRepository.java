package trim.domains.tag.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.tag.dao.entity.BoardTag;

public interface BoardTagRepository extends JpaRepository<BoardTag, Long> {
}
