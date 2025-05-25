package trim.domains.avatar.dao.repository.possessed;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.avatar.dao.entity.possessed.PossessedMouth;
import trim.domains.member.dao.domain.Member;

public interface PossessedMouthRepository extends JpaRepository<PossessedMouth, Long> {
    PossessedMouth findPossessedMouthAndMember(Long MouthId, Member member);
}
