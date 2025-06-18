package trim.domains.avatar.business.adaptor.possessed;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.avatar.dao.entity.item.Cloth;
import trim.domains.avatar.dao.entity.possessed.PossessedCloth;
import trim.domains.avatar.dao.repository.possessed.PossessedClothRepository;
import trim.domains.member.dao.domain.Member;

import java.util.List;

@Adaptor
@RequiredArgsConstructor
public class PossessedClothAdaptorImpl implements PossessedClothAdaptor{

    private final PossessedClothRepository possessedClothRepository;

    @Override
    public List<PossessedCloth> queryByPossessedClothId(Cloth cloth, Member member) {
        return possessedClothRepository.findByCloth_IdAndMember(cloth.getId(), member);
    }

    @Override
    public List<PossessedCloth> queryByMember(Member member) {
        return possessedClothRepository.findByMember(member);
    }
}
