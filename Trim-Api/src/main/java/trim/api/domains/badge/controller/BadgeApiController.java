package trim.api.domains.badge.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.badge.service.*;
import trim.api.domains.badge.vo.response.BadgeDetailResponse;
import trim.common.annotation.AuthUser;
import trim.domains.badge.dao.entity.BadgeContent;
import trim.domains.member.dao.domain.Member;

import java.util.List;

@Tag(name = "[뱃지🔑]")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/badges")
public class BadgeApiController {

    private final UpgradeBadgeLevelUseCase upgradeBadgeLevelUseCase;
    private final CountUpBadgeUseCase countUpBadgeUseCase;
    private final GetAllBadgesByMemberUseCase getAllBadgesByMemberUseCase;
    private final SelectBadgeUseCase selectBadgeUseCase;
    private final UnselectBadgeUseCase unselectBadgeUseCase;
    private final GetSelectedBadgeUseCase getSelectedBadgeUseCase;


    @Operation(summary = "모든 뱃지를 조회합니다. 이때 사용자의 미션 상태를 반영하여 값을 가져옵니다.")
    @GetMapping
    public ApiResponseDto<List<BadgeDetailResponse>> getAllBadgesByMember(@Parameter(hidden = true) @AuthUser Member member) {
        return ApiResponseDto.onSuccess(getAllBadgesByMemberUseCase.execute(member));
    }

    @Operation(summary = "미션의 단계를 업그레이드 합니다. 현재 완성한 배지를 획득합니다.")
    @PatchMapping("/{badgeId}")
    public ApiResponseDto<Integer> upgradeBadgeLevel(@Parameter(hidden = true) @AuthUser Member member,
                                                     @PathVariable Long badgeId) {
        return ApiResponseDto.onSuccess(upgradeBadgeLevelUseCase.execute(badgeId, member));
    }

    @Operation(summary = "여러 종류의 미션의 카운트를 하나 올려줍니다.(좋아요 제외)")
    @PatchMapping
    public ApiResponseDto<Void> countUpBadge(@Parameter(hidden = true) @AuthUser Member member,
                                             @RequestParam BadgeContent badgeContent) {
        countUpBadgeUseCase.execute(badgeContent, member);
        return ApiResponseDto.onSuccess(null);
    }

    @Operation(summary = "배지를 선택합니다. 개인이 선택할 수 있는 배지는 최대 3개입니다.")
    @PatchMapping("/selected/{badgeId}")
    public ApiResponseDto<Long> selectBadge(@Parameter(hidden = true) @AuthUser Member member,
                                            @PathVariable Long badgeId) {
        return ApiResponseDto.onSuccess(selectBadgeUseCase.execute(member, badgeId));
    }

    @Operation(summary = "배지 선택을 취소합니다.")
    @PatchMapping("/{badgeId}/unselect")
    public ApiResponseDto<Long> unselectBadge(@Parameter(hidden = true) @AuthUser Member member,
                                              @PathVariable Long badgeId) {
        return ApiResponseDto.onSuccess(unselectBadgeUseCase.execute(member, badgeId));
    }

    @Operation(summary = "선택한 배지들을 조회합니다.")
    @GetMapping("/selected")
    public ApiResponseDto<List<BadgeDetailResponse>> getSelectedBadge(
            @Parameter(hidden = true) @AuthUser Member member) {
        return ApiResponseDto.onSuccess(getSelectedBadgeUseCase.execute(member));
    }

}
