package trim.domains.answer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.answer.domain.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
