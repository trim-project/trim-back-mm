package trim.domains.avatar.dao.repository.possessed;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.avatar.dao.entity.possessed.PossessedHair;
import trim.domains.member.dao.domain.Member;

public interface PossessedHairRepository extends JpaRepository<PossessedHair, Long> {
    PossessedHair findPossessedHairAndMember(Long HairId, Member member);
}
