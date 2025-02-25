package trim.domains.board.dao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import trim.domains.board.dao.domain.Knowledge;
import trim.domains.board.dao.domain.Question;
import trim.domains.member.dao.domain.Member;

import java.util.List;
import java.util.Optional;

public interface KnowledgeRepository extends JpaRepository<Knowledge, Long> {
    List<Knowledge> findByWriter(Member writer);

    Page<Knowledge> findAll(Pageable pageable);

    @Query("""
            SELECT k FROM Knowledge k 
            LEFT JOIN Like l ON k.id = l.boardId 
            GROUP BY k.id
            ORDER BY COUNT(l) DESC, k.createdAt DESC
            """)
    Page<Knowledge> findHotKnowledge(Pageable pageable);
}
