package trim.domains.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.comment.domain.QuestionComment;

public interface QuestionCommentRepository extends JpaRepository<QuestionComment, Long> {
}
