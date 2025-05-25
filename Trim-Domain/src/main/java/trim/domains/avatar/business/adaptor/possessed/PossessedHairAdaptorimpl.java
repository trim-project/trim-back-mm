package trim.domains.avatar.business.adaptor.possessed;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.avatar.dao.entity.item.Hair;
import trim.domains.avatar.dao.entity.possessed.PossessedHair;
import trim.domains.avatar.dao.repository.possessed.PossessedHairRepository;
import trim.domains.member.dao.domain.Member;

@Adaptor
@RequiredArgsConstructor
public class PossessedHairAdaptorimpl implements PossessedHairAdaptor{

    private final PossessedHairRepository possessedHairRepository;

    @Override
    public PossessedHair queryByPossessedHairId (Hair hair, Member member) {
        return possessedHairRepository.findPossessedHairAndMember(hair.getId(), member);
    }
}
