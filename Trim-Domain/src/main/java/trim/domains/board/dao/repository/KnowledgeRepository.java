package trim.domains.board.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.board.dao.domain.Knowledge;

public interface KnowledgeRepository extends JpaRepository<Knowledge, Long> {
}
