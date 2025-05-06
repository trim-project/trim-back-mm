package trim.domains.reply.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.reply.dao.entity.Reply;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByCommentId(Long commentId);

}
