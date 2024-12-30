package trim.domains.answer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import trim.domains.answer.domain.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query("select (count(a) > 0) from Answer a where a.question.id = :questionId")
    boolean existsByQuestionId(@Param("questionId") Long questionId);
}
