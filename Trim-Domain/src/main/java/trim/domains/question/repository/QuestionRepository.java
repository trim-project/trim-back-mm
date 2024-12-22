package trim.domains.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.member.domain.Member;
import trim.domains.question.domain.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByWriter(Member writer);

    List<Question> findByWriterUsername(String username);
}
