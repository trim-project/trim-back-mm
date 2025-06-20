package trim.api.domains.avatar.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.avatar.service.parts.GetPurchasedClothPartsUseCase;
import trim.api.domains.avatar.service.parts.GetPurchasedEyesPartsUseCase;
import trim.api.domains.avatar.service.parts.GetPurchasedHairPartsUseCase;
import trim.api.domains.avatar.service.parts.GetPurchasedMouthPartsUseCase;
import trim.api.domains.avatar.service.possessed.PurchaseClothUseCase;
import trim.api.domains.avatar.service.possessed.PurchaseEyesUseCase;
import trim.api.domains.avatar.service.possessed.PurchaseHairUseCase;
import trim.api.domains.avatar.service.possessed.PurchaseMouthUseCase;
import trim.api.domains.avatar.service.stored.StoredAvatarUseCase;
import trim.api.domains.avatar.vo.request.stored.StoredAvatarRequest;
import trim.api.domains.avatar.vo.response.parts.*;
import trim.common.annotation.AuthUser;
import trim.domains.avatar.dao.entity.enums.ClothColor;
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
    private final GetPurchasedClothPartsUseCase getPurchasedClothPartsUseCase;
    private final GetPurchasedMouthPartsUseCase getPurchasedMouthPartsUseCase;
    private final GetPurchasedEyesPartsUseCase getPurchaseEyesPartsUseCase;
    private final StoredAvatarUseCase storedAvatarUseCase;

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

    @Operation(summary = "모든 의상 요소를 구매 여부와 함께 조회합니다.")
    @GetMapping("/cloth-parts/possessed")
    public ApiResponseDto<List<ClothPartsPossessedResponse>> getPossessedClothParts(@Parameter(hidden = true) @AuthUser Member member,
                                                                                    @RequestParam("color") ClothColor color) {
        return ApiResponseDto.onSuccess(getPurchasedClothPartsUseCase.execute(member, color));
    }

    @Operation(summary = "모든 입 요소를 구매 여부와 함께 조회합니다.")
    @GetMapping("/mouth-parts/possessed")
    public ApiResponseDto<List<MouthPartsPossessedResponse>> getPossessedMouthParts(@Parameter(hidden = true) @AuthUser Member member) {
        return ApiResponseDto.onSuccess(getPurchasedMouthPartsUseCase.execute(member));
    }

    @Operation(summary = "모든 눈 요소를 구매 여부와 함께 조회합니다.")
    @GetMapping("/eyes-parts/possessed")
    public ApiResponseDto<List<EyesPartsPossessedResponse>> getPossessedEyesParts(@Parameter(hidden = true) @AuthUser Member member) {
        return ApiResponseDto.onSuccess(getPurchaseEyesPartsUseCase.execute(member));
    }

    @Operation(summary = "구매한 요소로 아바타 조합과 배경색을 저장합니다")
    @PatchMapping("/stored")
    public ApiResponseDto<Long> storeAvatar(@Parameter(hidden = true) @AuthUser Member member,
                                            @RequestBody StoredAvatarRequest request) {
        return ApiResponseDto.onSuccess(storedAvatarUseCase.execute(member, request));
    }

}
