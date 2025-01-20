package trim.domains.board.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.board.dao.domain.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByWriterProfileUsername(String username);
}
