package trim.api.domains.avatar.service.parts;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import trim.api.domains.avatar.vo.response.parts.ClothPartsPossessedResponse;
import trim.common.annotation.UseCase;
import trim.domains.avatar.business.adaptor.parts.ClothPartsAdaptor;
import trim.domains.avatar.business.adaptor.possessed.PossessedClothAdaptor;
import trim.domains.avatar.dao.entity.enums.ClothColor;
import trim.domains.avatar.dao.entity.parts.ClothParts;
import trim.domains.avatar.dao.entity.possessed.PossessedCloth;
import trim.domains.member.dao.domain.Member;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@UseCase
@Transactional
@RequiredArgsConstructor
public class GetPurchasedClothPartsUseCase {

    private final ClothPartsAdaptor clothPartsAdaptor;
    private final PossessedClothAdaptor possessedClothAdaptor;

    public List<ClothPartsPossessedResponse> execute(Member member, ClothColor clothColor) {

        List<ClothParts> parts = clothPartsAdaptor.queryClothPartsByColor(clothColor);
        List<PossessedCloth> possessedCloths = possessedClothAdaptor.queryByMember(member);

        Set<Long> possessedClothIds = possessedCloths.stream()
                .map(pc -> pc.getCloth().getId())
                .collect(Collectors.toSet());

        return parts.stream()
                .map(part -> ClothPartsPossessedResponse.builder()
                        .clothId(part.getCloth().getId())
                        .price(part.getCloth().getPrice())
                        .clothForURL(part.getImageUrl().getKey())
                        .purchased(possessedClothIds.contains(part.getCloth().getId()))
                        .build())
                .toList();

    }
}
