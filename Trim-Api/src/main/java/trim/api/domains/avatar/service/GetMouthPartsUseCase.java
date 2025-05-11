package trim.api.domains.avatar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.avatar.mapper.parts.MouthPartsMapper;
import trim.api.domains.avatar.vo.response.parts.MouthPartsResponse;
import trim.common.annotation.UseCase;
import trim.domains.avatar.business.adaptor.parts.MouthPartsAdaptor;
import trim.domains.avatar.dao.entity.parts.MouthParts;

import java.util.List;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetMouthPartsUseCase {

    private final MouthPartsAdaptor mouthPartsAdaptor;

    public List<MouthPartsResponse> execute() {
        List<MouthParts> parts = mouthPartsAdaptor.queryMouthParts();
        return parts.stream()
                .map(MouthPartsMapper.INSTANCE::toResponse)
                .toList();
    }
}
