package trim.domains.avatar.dao.repository.possessed;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.avatar.dao.entity.possessed.PossessedCloth;
import trim.domains.member.dao.domain.Member;

import java.util.List;

public interface PossessedClothRepository extends JpaRepository<PossessedCloth, Long> {
    List<PossessedCloth> findByCloth_IdAndMember(Long ClothId, Member member);
}
