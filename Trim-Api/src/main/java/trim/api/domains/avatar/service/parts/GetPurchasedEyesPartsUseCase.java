package trim.api.domains.avatar.service.parts;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import trim.api.domains.avatar.vo.response.parts.EyesPartsPossessedResponse;
import trim.common.annotation.UseCase;
import trim.domains.avatar.business.adaptor.parts.EyesPartsAdaptor;
import trim.domains.avatar.business.adaptor.possessed.PossessedEyesAdaptor;
import trim.domains.avatar.dao.entity.parts.EyesParts;
import trim.domains.avatar.dao.entity.possessed.PossessedEyes;
import trim.domains.member.dao.domain.Member;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@UseCase
@Transactional
@RequiredArgsConstructor
public class GetPurchasedEyesPartsUseCase {

    private final EyesPartsAdaptor eyesPartsAdaptor;
    private final PossessedEyesAdaptor possessedEyesAdaptor;

    public List<EyesPartsPossessedResponse> execute(Member member) {

        List<EyesParts> parts = eyesPartsAdaptor.queryEyesParts();
        List<PossessedEyes> possessedEyes = possessedEyesAdaptor.queryByMember(member);

        Set<Long> possessedEyesIds = possessedEyes.stream()
                .map(pe -> pe.getEyes().getId())
                .collect(Collectors.toSet());

        return parts.stream()
                .map(part -> EyesPartsPossessedResponse.builder()
                        .eyesId(part.getEyes().getId())
                        .price(part.getEyes().getPrice())
                        .imageUrl(part.getImageUrl().getKey())
                        .purchased(possessedEyesIds.contains(part.getEyes().getId()))
                        .build())
                .toList();

    }

}
