package trim.api.domains.avatar.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.avatar.service.possessed.PurchaseHairUseCase;
import trim.common.annotation.AuthUser;
import trim.domains.member.dao.domain.Member;

@Tag(name = "[아바타🔑]")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/avatars")
public class AvatarApiController {

    private final PurchaseHairUseCase purchaseHairUseCase;

    @Operation(summary = "의상 요소를 구매합니다.")
    @PostMapping
    public ApiResponseDto<Long> purchaseCloth(@Parameter(hidden = true) @AuthUser Member member,
                                                     @RequestParam Long clothId) {
        return ApiResponseDto.onSuccess(purchaseHairUseCase.execute(member, clothId));
    }

    @Operation(summary = "눈 요소를 구매합니다.")
    @PostMapping
    public ApiResponseDto<Long> purchaseEyes(@Parameter(hidden = true) @AuthUser Member member,
                                             @RequestParam Long eyesId) {
        return ApiResponseDto.onSuccess(purchaseHairUseCase.execute(member, eyesId));
    }

    @Operation(summary = "헤어 요소를 구매합니다.")
    @PostMapping
    public ApiResponseDto<Long> purchaseHair(@Parameter(hidden = true) @AuthUser Member member,
                                             @RequestParam Long hairId) {
        return ApiResponseDto.onSuccess(purchaseHairUseCase.execute(member, hairId));
    }

    @Operation(summary = "입 요소를 구매합니다.")
    @PostMapping
    public ApiResponseDto<Long> purchaseMouth(@Parameter(hidden = true) @AuthUser Member member,
                                             @RequestParam Long mouthId) {
        return ApiResponseDto.onSuccess(purchaseHairUseCase.execute(member, mouthId));
    }

}
