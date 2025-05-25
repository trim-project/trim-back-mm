package trim.domains.avatar.business.adaptor.possessed;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.avatar.dao.entity.possessed.PossessedCloth;
import trim.domains.avatar.dao.repository.possessed.PossessedClothRepository;
import trim.domains.member.dao.domain.Member;

@Adaptor
@RequiredArgsConstructor
public class PossessedClothAdaptorImpl implements PossessedClothAdaptor{

    private final PossessedClothRepository possessedClothRepository;

    @Override
    public PossessedCloth queryByPossessedClothId(Long ClothId, Member member) {
        return possessedClothRepository.findPossessedClothAndMember(ClothId, member);
    }
}
