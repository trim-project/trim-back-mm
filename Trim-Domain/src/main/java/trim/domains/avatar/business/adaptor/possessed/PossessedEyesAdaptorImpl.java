package trim.domains.avatar.business.adaptor.possessed;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.avatar.dao.entity.item.Eyes;
import trim.domains.avatar.dao.entity.possessed.PossessedEyes;
import trim.domains.avatar.dao.repository.possessed.PossessedEyesRepository;
import trim.domains.member.dao.domain.Member;

@Adaptor
@RequiredArgsConstructor
public class PossessedEyesAdaptorImpl implements PossessedEyesAdaptor{

    private final PossessedEyesRepository possessedEyesRepository;

    @Override
    public PossessedEyes queryByPossessedEyesId(Eyes eyes, Member member) {
        return possessedEyesRepository.findPossessedEyesAndMember(eyes.getId(), member);
    }

}
