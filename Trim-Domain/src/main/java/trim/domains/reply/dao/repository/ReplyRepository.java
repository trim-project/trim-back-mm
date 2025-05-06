package trim.domains.reply.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.reply.dao.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
