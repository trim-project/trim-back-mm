package trim.domains.avatar.business.adaptor.parts;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.avatar.dao.entity.parts.MouthParts;
import trim.domains.avatar.dao.repository.parts.MouthPartsRepository;

import java.util.List;

@Adaptor
@RequiredArgsConstructor
public class MouthPartsAdaptorImpl implements MouthPartsAdaptor {

    private final MouthPartsRepository mouthPartsRepository;

    @Override
    public List<MouthParts> queryMouthParts() {
        return mouthPartsRepository.findAll();
    }
}
