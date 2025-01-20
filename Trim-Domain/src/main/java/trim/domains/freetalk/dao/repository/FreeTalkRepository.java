package trim.domains.freetalk.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.freetalk.dao.domain.FreeTalk;
import trim.domains.member.dao.domain.Member;

import java.util.List;

public interface FreeTalkRepository extends JpaRepository<FreeTalk, Long> {

    List<FreeTalk> findByWriter(Member member);
}
