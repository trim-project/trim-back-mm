package trim.domains.board.dao.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import trim.domains.board.dao.domain.Question;
import trim.domains.board.dao.repository.querydsl.QuestionQueryRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long>, QuestionQueryRepository {
    List<Question> findByWriterProfileUsername(String username);

    Page<Question> findAll(Pageable pageable);

    @Query("""
    SELECT q FROM Question q 
    LEFT JOIN Like l ON q.id = l.boardId 
    GROUP BY q.id
    ORDER BY COUNT(l) DESC, q.createdAt DESC
    """)
    Page<Question> findHotQuestions(Pageable pageable);
}
