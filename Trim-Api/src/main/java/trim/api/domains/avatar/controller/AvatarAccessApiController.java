package trim.api.domains.avatar.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.avatar.service.parts.GetClothPartsUseCase;
import trim.api.domains.avatar.service.parts.GetEyesPartsUseCase;
import trim.api.domains.avatar.service.parts.GetHairPartsUseCase;
import trim.api.domains.avatar.service.parts.GetMouthPartsUseCase;
import trim.api.domains.avatar.vo.response.parts.ClothPartsResponse;
import trim.api.domains.avatar.vo.response.parts.EyesPartsResponse;
import trim.api.domains.avatar.vo.response.parts.HairPartsResponse;
import trim.api.domains.avatar.vo.response.parts.MouthPartsResponse;
import trim.domains.avatar.dao.entity.enums.ClothColor;
import trim.domains.avatar.dao.entity.enums.HairColor;

import java.util.List;

@Tag(name = "[아바타]")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/access/avatars")
public class AvatarAccessApiController {

    private final GetHairPartsUseCase getHairPartsByColorUseCase;
    private final GetClothPartsUseCase getClothPartsUseCase;
    private final GetEyesPartsUseCase getEyesPartsUseCase;
    private final GetMouthPartsUseCase getMouthPartsUseCase;

    @Operation(summary = "구매에 상관없이 모든 아바타의 헤어 요소를 조회합니다.")
    @GetMapping("/hair-parts")
    public ApiResponseDto<List<HairPartsResponse>> getHairPartsByColor(@RequestParam("color") HairColor color) {
        return ApiResponseDto.onSuccess(getHairPartsByColorUseCase.execute(color));
    }

    @Operation(summary = "구매에 상관없이 모든 아바타의 의상 요소를 조회합니다.")
    @GetMapping("/cloth-parts")
    public ApiResponseDto<List<ClothPartsResponse>> getClothPartsByColor(@RequestParam("color") ClothColor color) {
        return ApiResponseDto.onSuccess(getClothPartsUseCase.execute(color));
    }

    @Operation(summary = "구매에 상관없이 모든 아바타의 눈 요소를 조회합니다. ")
    @GetMapping("/eyes-parts")
    public ApiResponseDto<List<EyesPartsResponse>> getEyesPartsByColor() {
        return ApiResponseDto.onSuccess(getEyesPartsUseCase.execute());
    }

    @Operation(summary = "구매에 상관없이 모든 아바타의 입 요소를 조회합니다. ")
    @GetMapping("/mouth-parts")
    public ApiResponseDto<List<MouthPartsResponse>> getMouthPartsByColor() {
        return ApiResponseDto.onSuccess(getMouthPartsUseCase.execute());
    }

    @Operation(summary = "모든 헤어 요소를 구매 여부와 함께 조회합니다.")
    @GetMapping("/hair-parts/possessed")
    public ApiResponseDto<List<HairPartsPossessedResponse>> getPossessedHairParts() {
        return ApiResponseDto.onSuccess(getPossessedHairPartsUseCase.execute());
    }

}

