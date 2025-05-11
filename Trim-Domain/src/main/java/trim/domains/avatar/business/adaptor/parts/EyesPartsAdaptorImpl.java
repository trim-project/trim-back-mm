package trim.domains.avatar.business.adaptor.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import trim.domains.avatar.dao.entity.parts.EyesParts;
import trim.domains.avatar.dao.repository.parts.EyesPartsRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EyesPartsAdaptorImpl implements EyesPartsAdaptor {

    private final EyesPartsRepository eyesPartsRepository;

    @Override
    public List<EyesParts> queryEyesParts() {
        return eyesPartsRepository.findAll();
    }

}
