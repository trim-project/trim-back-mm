package trim.domains.avatar.business.adaptor.possessed;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.avatar.dao.entity.item.Cloth;
import trim.domains.avatar.dao.entity.possessed.PossessedCloth;
import trim.domains.avatar.dao.repository.possessed.PossessedClothRepository;
import trim.domains.member.dao.domain.Member;

@Adaptor
@RequiredArgsConstructor
public class PossessedClothAdaptorImpl implements PossessedClothAdaptor{

    private final PossessedClothRepository possessedClothRepository;

    @Override
    public PossessedCloth queryByPossessedClothId(Cloth cloth, Member member) {
        return possessedClothRepository.findPossessedClothAndMember(cloth.getId(), member);
    }
}
