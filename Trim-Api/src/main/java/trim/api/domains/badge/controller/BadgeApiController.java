package trim.api.domains.badge.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.badge.service.CountUpBadgeOfWritingBoardUseCase;
import trim.api.domains.badge.service.GetAllBadgesByMemberUseCase;
import trim.api.domains.badge.service.UpgradeBadgeLevelUseCase;
import trim.api.domains.badge.vo.response.BadgeDetailResponse;
import trim.common.annotation.AuthUser;
import trim.common.util.EnumConvertUtil;
import trim.domains.badge.dao.entity.BadgeContent;
import trim.domains.member.dao.domain.Member;

import java.util.List;

@Tag(name = "[뱃지🔑]")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/badges")
public class BadgeApiController {

    private final UpgradeBadgeLevelUseCase upgradeBadgeLevelUseCase;
    private final CountUpBadgeOfWritingBoardUseCase countUpBadgeOfWritingBoardUseCase;
    private final GetAllBadgesByMemberUseCase getAllBadgesByMemberUseCase;


    @Operation(summary = "모든 뱃지를 조회합니다. 이때 사용자의 미션 상태를 반영하여 값을 가져옵니다.")
    @GetMapping
    public ApiResponseDto<List<BadgeDetailResponse>> getAllBadgesByMember(@Parameter(hidden = true) @AuthUser Member member) {
        return ApiResponseDto.onSuccess(getAllBadgesByMemberUseCase.execute(member));
    }

    @Operation(summary = "미션의 단계를 업그레이드 합니다. 현재 완성한 배지를 획득합니다.")
    @PostMapping("/{badgeId}")
    public ApiResponseDto<Integer> upgradeBadgeLevel(@Parameter(hidden = true) @AuthUser Member member,
                                                     @PathVariable Long badgeId) {
        return ApiResponseDto.onSuccess(upgradeBadgeLevelUseCase.execute(badgeId, member));
    }

    @Operation(summary = "게시글 작성을 함으로써 미션의 카운트를 하나 올려줍니다.")
    @PatchMapping("/boards")
    public ApiResponseDto<Long> countUpBadgeOfWritingBoard(@Parameter(hidden = true) @AuthUser Member member,
                                                           @RequestParam String badgeContentKey) {
        BadgeContent badgeContent = EnumConvertUtil.convert(BadgeContent.class, badgeContentKey);
        return ApiResponseDto.onSuccess(countUpBadgeOfWritingBoardUseCase
                .execute(badgeContent, member));
    }

    @Operation(summary = "게시글 작성을 함으로써 미션의 카운트를 하나 올려줍니다.")
    @PatchMapping("/comments")
    public ApiResponseDto<Long> countUpBadgeOfWritingComment(@Parameter(hidden = true) @AuthUser Member member) {
        return ApiResponseDto.onSuccess(countUpBadgeOfWritingBoardUseCase
                .execute(BadgeContent.WRITE_COMMENT, member));
    }

}
