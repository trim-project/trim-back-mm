package trim.domains.avatar.business.adaptor.possessed;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.avatar.dao.entity.possessed.PossessedMouth;
import trim.domains.avatar.dao.repository.possessed.PossessedMouthRepository;
import trim.domains.member.dao.domain.Member;

@Adaptor
@RequiredArgsConstructor
public class PossessedMouthAdaptorImpl implements PossessedMouthAdaptor{

    private final PossessedMouthRepository possessedMouthRepository;

    @Override
    public PossessedMouth queryByPossessedMouthId(Long mouthId, Member member) {
        return possessedMouthRepository.findPossessedMouthAndMember(mouthId, member);
    }
}
