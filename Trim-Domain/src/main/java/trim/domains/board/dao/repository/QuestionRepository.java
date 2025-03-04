package trim.domains.board.dao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import trim.domains.board.dao.domain.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByWriterProfileUsername(String username);

    Page<Question> findAll(Pageable pageable);

    @Query("""
    SELECT q FROM Question q 
    LEFT JOIN Like l ON q.id = l.boardId 
    GROUP BY q.id
    ORDER BY COUNT(l) DESC, q.createdAt DESC
    """)
    Page<Question> findHotQuestions(Pageable pageable);

    @Query("SELECT q FROM Question q WHERE q.id IN :boardIds")
    Page<Question> findQuestionsByBoardIds(@Param("boardIds") List<Long> boardIds);
}
