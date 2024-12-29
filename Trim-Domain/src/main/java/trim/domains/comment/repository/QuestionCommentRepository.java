package trim.domains.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import trim.domains.comment.domain.QuestionComment;

import java.util.List;

public interface QuestionCommentRepository extends JpaRepository<QuestionComment, Long> {

    @Query("select qc from QuestionComment qc where qc.question.id = :questionId")
    List<QuestionComment> findAllByQuestionId(@Param("questionId") Long questionId);

    @Query("delete from QuestionComment qc where qc.question.id = :questionId")
    void deleteAllByQuestionId(@Param("questionId") Long questionId);

}
