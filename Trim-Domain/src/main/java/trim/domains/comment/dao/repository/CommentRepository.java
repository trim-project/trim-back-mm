package trim.domains.comment.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.comment.dao.domain.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBoardId(Long boardId);

    Long countByBoardId(Long boardId);
}
