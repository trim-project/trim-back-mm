package trim.domains.question.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.member.dao.domain.Member;
import trim.domains.question.dao.domain.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByWriter(Member writer);

    List<Question> findByWriterProfileUsername(String username);


}
