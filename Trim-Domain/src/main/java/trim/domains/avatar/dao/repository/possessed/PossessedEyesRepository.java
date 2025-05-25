package trim.domains.avatar.dao.repository.possessed;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.avatar.dao.entity.possessed.PossessedEyes;
import trim.domains.member.dao.domain.Member;

public interface PossessedEyesRepository extends JpaRepository<PossessedEyes, Long> {
    PossessedEyes findPossessedEyesAndMember(Long EyesId, Member member);
}
