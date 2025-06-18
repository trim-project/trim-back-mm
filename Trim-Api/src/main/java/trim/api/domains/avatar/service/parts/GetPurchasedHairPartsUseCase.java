package trim.api.domains.avatar.service.parts;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import trim.api.domains.avatar.vo.response.parts.HairPartsPossessedResponse;
import trim.common.annotation.UseCase;
import trim.domains.avatar.business.adaptor.parts.HairPartsAdaptor;
import trim.domains.avatar.business.adaptor.possessed.PossessedHairAdaptor;
import trim.domains.avatar.dao.entity.enums.HairColor;
import trim.domains.avatar.dao.entity.parts.HairParts;
import trim.domains.avatar.dao.entity.possessed.PossessedHair;
import trim.domains.member.dao.domain.Member;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@UseCase
@Transactional
@RequiredArgsConstructor
public class GetPurchasedHairPartsUseCase {

    private final HairPartsAdaptor hairPartsAdaptor;
    private final PossessedHairAdaptor possessedHairAdaptor;

    public List<HairPartsPossessedResponse> execute(Member member, HairColor hairColor) {

        List<HairParts> parts = hairPartsAdaptor.queryHairPartsByColor(hairColor);
        List<PossessedHair> possessedHairs = possessedHairAdaptor.queryByMember(member);

        Set<Long> possessedHairIds = possessedHairs.stream()
                .map(ph -> ph.getHair().getId())
                .collect(Collectors.toSet());

        return parts.stream()
                .map(part -> HairPartsPossessedResponse.builder()
                        .hairId(part.getHair().getId())
                        .price(part.getHair().getPrice())
                        .hairForURL(part.getImageUrl().getKey())
                        .purchased(possessedHairIds.contains(part.getHair().getId()))
                        .build())
                .toList();

    }
}
