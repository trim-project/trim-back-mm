package trim.domains.board.dao.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import trim.domains.board.dao.domain.FreeTalk;
import trim.domains.member.dao.domain.Member;

import java.util.List;

public interface FreeTalkRepository extends JpaRepository<FreeTalk, Long> {

    List<FreeTalk> findByWriter(Member member);

    Page<FreeTalk> findAll(Pageable pageable);

    @Query("""
    SELECT f FROM FreeTalk f 
    LEFT JOIN Like l ON f.id = l.boardId 
    GROUP BY f.id
    ORDER BY COUNT(l) DESC, f.createdAt DESC
    """)
    Page<FreeTalk> findHotFreeTalks(Pageable pageable);
}
