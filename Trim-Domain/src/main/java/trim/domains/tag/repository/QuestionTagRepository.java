package trim.domains.tag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.tag.dao.entity.BoardTag;

public interface QuestionTagRepository extends JpaRepository<BoardTag, Long> {

}
