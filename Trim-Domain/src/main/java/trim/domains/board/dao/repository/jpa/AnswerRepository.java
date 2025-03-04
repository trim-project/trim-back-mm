package trim.domains.board.dao.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.board.dao.domain.Answer;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    boolean existsByQuestionId(Long id);

    List<Answer> findByQuestionId(Long questionId);

    Long countByQuestionId(Long questionId);

}
