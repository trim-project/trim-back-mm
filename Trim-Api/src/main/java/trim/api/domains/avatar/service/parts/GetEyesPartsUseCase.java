package trim.api.domains.avatar.service.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.avatar.mapper.parts.EyesPartsMapper;
import trim.api.domains.avatar.vo.response.parts.EyesPartsResponse;
import trim.common.annotation.UseCase;
import trim.domains.avatar.business.adaptor.parts.EyesPartsAdaptor;
import trim.domains.avatar.dao.entity.parts.EyesParts;

import java.util.List;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetEyesPartsUseCase {

    private final EyesPartsAdaptor eyesPartsAdaptor;

    public List<EyesPartsResponse> execute() {
        List<EyesParts> parts = eyesPartsAdaptor.queryEyesParts();

        return parts.stream()
                .map(part -> new EyesPartsResponse(
                        part.getEyes().getId(),
                        part.getEyes().getPrice(),
                        part.getImageUrl().getKey()
                ))
                .toList();
    }
}
