package trim.api.domains.badge.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.badge.service.GetAllBadgesUseCase;
import trim.api.domains.badge.service.UpgradeBadgeLevelUseCase;
import trim.api.domains.badge.vo.response.BadgeResponse;

import java.util.List;

@Tag(name = "[뱃지]")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/badges")
public class BadgeApiController {

    private final GetAllBadgesUseCase getAllBadgesUseCase;
    private final UpgradeBadgeLevelUseCase upgradeBadgeLevelUseCase;

    @Operation(summary = "모든 뱃지를 조회합니다.")
    @GetMapping
    public ApiResponseDto<List<BadgeResponse>> getAllBadges() {
        return ApiResponseDto.onSuccess(getAllBadgesUseCase.execute());
    }

    @Operation(summary = "미션의 단계를 업그레이드 합니다. 현재 완성한 배지를 획득합니다.")
    @PutMapping("/{badgeId}/members/{memberId}")
    public ApiResponseDto<Integer> upgradeBadgeLevel(@PathVariable Long badgeId,
                                                     @PathVariable Long memberId) {
        return ApiResponseDto.onSuccess(upgradeBadgeLevelUseCase.execute(badgeId, memberId));
    }
}
