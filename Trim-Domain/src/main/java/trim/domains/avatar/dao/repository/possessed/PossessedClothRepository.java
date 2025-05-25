package trim.domains.avatar.dao.repository.possessed;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.avatar.dao.entity.possessed.PossessedCloth;
import trim.domains.member.dao.domain.Member;

public interface PossessedClothRepository extends JpaRepository<PossessedCloth, Long> {
    PossessedCloth findPossessedClothAndMember(Long ClothId, Member member);
}
