package trim.domains.tag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.tag.domain.QuestionTag;

public interface QuestionTagRepository extends JpaRepository<QuestionTag, Long> {

}
