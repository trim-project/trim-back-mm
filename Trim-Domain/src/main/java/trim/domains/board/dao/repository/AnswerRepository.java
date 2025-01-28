package trim.domains.board.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import trim.domains.board.dao.domain.Answer;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    boolean existsByQuestionId(Long id);

    List<Answer> findByQuestionId(Long questionId);
}
