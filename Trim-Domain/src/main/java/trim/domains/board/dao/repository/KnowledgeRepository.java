package trim.domains.board.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.board.dao.domain.Knowledge;
import trim.domains.member.dao.domain.Member;

import java.util.List;
import java.util.Optional;

public interface KnowledgeRepository extends JpaRepository<Knowledge, Long> {
    List<Knowledge> findByWriter(Member writer);

    Optional<Knowledge> findByKnowledgeUuid(String knowledgeUuid);
}
