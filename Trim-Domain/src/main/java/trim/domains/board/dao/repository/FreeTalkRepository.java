package trim.domains.board.dao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.board.dao.domain.FreeTalk;
import trim.domains.member.dao.domain.Member;

import java.util.List;

public interface FreeTalkRepository extends JpaRepository<FreeTalk, Long> {

    List<FreeTalk> findByWriter(Member member);

    Page<FreeTalk> findAll(Pageable pageable);
}
