package trim.api.domains.avatar.service.parts;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import trim.api.domains.avatar.vo.response.parts.MouthPartsPossessedResponse;
import trim.common.annotation.UseCase;
import trim.domains.avatar.business.adaptor.parts.MouthPartsAdaptor;
import trim.domains.avatar.business.adaptor.possessed.PossessedMouthAdaptor;
import trim.domains.avatar.dao.entity.parts.MouthParts;
import trim.domains.avatar.dao.entity.possessed.PossessedMouth;
import trim.domains.member.dao.domain.Member;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@UseCase
@Transactional
@RequiredArgsConstructor
public class GetPurchasedMouthPartsUseCase {

    private final MouthPartsAdaptor mouthPartsAdaptor;
    private final PossessedMouthAdaptor possessedMouthAdaptor;

    public List<MouthPartsPossessedResponse> execute(Member member) {

        List<MouthParts> parts = mouthPartsAdaptor.queryMouthParts();
        List<PossessedMouth> possessedMouths = possessedMouthAdaptor.queryByMember(member);

        Set<Long> possessedMouthIds = possessedMouths.stream()
                .map(pm -> pm.getMouth().getId())
                .collect(Collectors.toSet());

        return parts.stream()
                .map(part -> MouthPartsPossessedResponse.builder()
                        .mouthId(part.getMouth().getId())
                        .price(part.getMouth().getPrice())
                        .mouthForURL(part.getImageUrl().getKey())
                        .purchased(possessedMouthIds.contains(part.getMouth().getId()))
                        .build())
                .toList();

    }
}
