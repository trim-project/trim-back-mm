package trim.domains.board.dao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import trim.domains.board.dao.domain.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByWriterProfileUsername(String username);

    Page<Question> findAll(Pageable pageable);

    @Query("""
    SELECT q FROM Question q 
    LEFT JOIN (SELECT l.boardId, COUNT(l) AS likeCount FROM Like l GROUP BY l.boardId) likes 
    ON q.id = likes.boardId
    ORDER BY COALESCE(likes.likeCount, 0) DESC, q.createdAt DESC
    """)
    Page<Question> findHotQuestions(Pageable pageable);
}
