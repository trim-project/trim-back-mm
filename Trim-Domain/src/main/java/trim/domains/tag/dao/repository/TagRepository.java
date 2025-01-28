package trim.domains.tag.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import trim.domains.tag.dao.entity.Tag;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByBoardId(Long boardId);
    @Query("SELECT t.name FROM Tag t WHERE t.boardId = :boardId")
    List<String> findNamesByBoardId(@Param("boardId") Long boardId);
}
