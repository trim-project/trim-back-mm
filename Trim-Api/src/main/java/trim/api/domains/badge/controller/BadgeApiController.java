package trim.api.domains.badge.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.badge.service.GetAllBadgesUseCase;
import trim.api.domains.badge.vo.response.BadgeResponse;

import java.util.List;

@Tag(name = "[뱃지]")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/badges")
public class BadgeApiController {

    private final GetAllBadgesUseCase getAllBadgesUseCase;

    @Operation(summary = "모든 뱃지를 조회합니다.")
    @GetMapping
    public ApiResponseDto<List<BadgeResponse>> getAllBadges() {
        return ApiResponseDto.onSuccess(getAllBadgesUseCase.execute());
    }
}
