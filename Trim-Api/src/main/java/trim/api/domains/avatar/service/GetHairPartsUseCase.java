package trim.api.domains.avatar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.avatar.mapper.parts.HairPartsMapper;
import trim.api.domains.avatar.vo.response.parts.HairPartsResponse;
import trim.common.annotation.UseCase;
import trim.domains.avatar.dao.entity.enums.HairColor;
import trim.domains.avatar.dao.entity.parts.HairParts;
import trim.domains.avatar.dao.repository.parts.HairPartsRepository;

import java.util.List;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetHairPartsUseCase {

    private final HairPartsRepository hairPartsRepository;

    public List<HairPartsResponse> execute(HairColor hairColor) {
        List<HairParts> parts = hairPartsRepository.findAllByHairColor(hairColor);
        return parts.stream()
                .map(HairPartsMapper.INSTANCE::toResponse)
                .toList();
    }
}

