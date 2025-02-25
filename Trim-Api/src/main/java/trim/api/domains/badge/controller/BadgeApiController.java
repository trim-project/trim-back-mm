package trim.api.domains.badge.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.badge.service.CountUpBadgeOfWritingBoardUseCase;
import trim.api.domains.badge.service.GetAllBadgesUseCase;
import trim.api.domains.badge.service.UpgradeBadgeLevelUseCase;
import trim.api.domains.badge.vo.response.BadgeDetailResponse;
import trim.api.domains.badge.vo.response.BadgeResponse;
import trim.common.util.EnumConvertUtil;
import trim.domains.badge.dao.entity.BadgeContent;

import java.util.List;

@Tag(name = "[뱃지]")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/badges")
public class BadgeApiController {

    private final GetAllBadgesUseCase getAllBadgesUseCase;
    private final UpgradeBadgeLevelUseCase upgradeBadgeLevelUseCase;
    private final CountUpBadgeOfWritingBoardUseCase countUpBadgeOfWritingBoardUseCase;

    @Operation(summary = "모든 뱃지를 조회합니다.")
    @GetMapping
    public ApiResponseDto<List<BadgeResponse>> getAllBadges() {
        return ApiResponseDto.onSuccess(getAllBadgesUseCase.execute());
    }

//    @Operation(summary = "모든 뱃지를 조회합니다. 이때 사용자의 미션 상태를 반영하여 값을 가져옵니다.")
//    @GetMapping("/members/{memberId}")
//    public ApiResponseDto<List<BadgeDetailResponse>> getAllBadgesByMember(@PathVariable Long memberId) {
//        return ApiResponseDto.onSuccess(getAllBadgesByMemberUseCase.execute(memberId));
//    }

    @Operation(summary = "미션의 단계를 업그레이드 합니다. 현재 완성한 배지를 획득합니다.")
    @PostMapping("/{badgeId}/members/{memberId}")
    public ApiResponseDto<Integer> upgradeBadgeLevel(@PathVariable Long badgeId,
                                                     @PathVariable Long memberId) {
        return ApiResponseDto.onSuccess(upgradeBadgeLevelUseCase.execute(badgeId, memberId));
    }

    @Operation(summary = "게시글 작성을 함으로써 미션의 카운트를 하나 올려줍니다.")
    @PutMapping("/boards/members/{memberId}")
    public ApiResponseDto<Long> countUpBadgeOfWritingBoard(@PathVariable Long memberId,
                                                           @RequestParam String badgeContentKey) {
        BadgeContent badgeContent = EnumConvertUtil.convert(BadgeContent.class, badgeContentKey);
        return ApiResponseDto.onSuccess(countUpBadgeOfWritingBoardUseCase
                .execute(badgeContent, memberId));
    }


}
