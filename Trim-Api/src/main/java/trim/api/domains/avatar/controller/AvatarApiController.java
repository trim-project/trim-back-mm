package trim.api.domains.avatar.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.avatar.service.parts.GetPurchasedHairPartsUseCase;
import trim.api.domains.avatar.service.possessed.PurchaseClothUseCase;
import trim.api.domains.avatar.service.possessed.PurchaseEyesUseCase;
import trim.api.domains.avatar.service.possessed.PurchaseHairUseCase;
import trim.api.domains.avatar.service.possessed.PurchaseMouthUseCase;
import trim.api.domains.avatar.vo.response.parts.HairPartsPossessedResponse;
import trim.common.annotation.AuthUser;
import trim.domains.avatar.dao.entity.enums.HairColor;
import trim.domains.member.dao.domain.Member;

import java.util.List;

@Tag(name = "[아바타🔑]")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/avatars")
public class AvatarApiController {

    private final PurchaseHairUseCase purchaseHairUseCase;
    private final PurchaseClothUseCase purchaseClothUseCase;
    private final PurchaseEyesUseCase purchaseEyesUseCase;
    private final PurchaseMouthUseCase purchaseMouthUseCase;
    private final GetPurchasedHairPartsUseCase getPurchasedHairPartsUseCase;

    @Operation(summary = "의상 요소를 구매합니다.")
    @PostMapping("/cloths/{clothId}")
    public ApiResponseDto<Long> purchaseCloth(@Parameter(hidden = true) @AuthUser Member member,
                                                     @PathVariable Long clothId) {
        return ApiResponseDto.onSuccess(purchaseClothUseCase.execute(member, clothId));
    }

    @Operation(summary = "눈 요소를 구매합니다.")
    @PostMapping("/eyes/{eyesId}")
    public ApiResponseDto<Long> purchaseEyes(@Parameter(hidden = true) @AuthUser Member member,
                                             @PathVariable Long eyesId) {
        return ApiResponseDto.onSuccess(purchaseEyesUseCase.execute(member, eyesId));
    }

    @Operation(summary = "헤어 요소를 구매합니다.")
    @PostMapping("/hairs/{hairId}")
    public ApiResponseDto<Long> purchaseHair(@Parameter(hidden = true) @AuthUser Member member,
                                             @PathVariable Long hairId) {
        return ApiResponseDto.onSuccess(purchaseHairUseCase.execute(member, hairId));
    }

    @Operation(summary = "입 요소를 구매합니다.")
    @PostMapping("/mouths/{mouthId}")
    public ApiResponseDto<Long> purchaseMouth(@Parameter(hidden = true) @AuthUser Member member,
                                             @PathVariable Long mouthId) {
        return ApiResponseDto.onSuccess(purchaseMouthUseCase.execute(member, mouthId));
    }

    @Operation(summary = "모든 헤어 요소를 구매 여부와 함께 조회합니다.")
    @GetMapping("/hair-parts/possessed")
    public ApiResponseDto<List<HairPartsPossessedResponse>> getPossessedHairParts(@Parameter(hidden = true) @AuthUser Member member,
                                                                                  @RequestParam("color") HairColor color) {
        return ApiResponseDto.onSuccess(getPurchasedHairPartsUseCase.execute(member, color));
    }

}
