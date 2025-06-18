package trim.domains.avatar.business.adaptor.possessed;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.avatar.dao.entity.item.Mouth;
import trim.domains.avatar.dao.entity.possessed.PossessedMouth;
import trim.domains.avatar.dao.repository.possessed.PossessedMouthRepository;
import trim.domains.member.dao.domain.Member;

import java.util.List;

@Adaptor
@RequiredArgsConstructor
public class PossessedMouthAdaptorImpl implements PossessedMouthAdaptor{

    private final PossessedMouthRepository possessedMouthRepository;

    @Override
    public List<PossessedMouth> queryByPossessedMouthId(Mouth mouth, Member member) {
        return possessedMouthRepository.findByMouth_IdAndMember(mouth.getId(), member);
    }
}
