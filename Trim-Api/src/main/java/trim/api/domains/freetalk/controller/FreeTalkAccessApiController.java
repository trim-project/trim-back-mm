package trim.api.domains.freetalk.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.common.util.PageUtil;
import trim.api.domains.freetalk.service.GetAllFreeTalkByPaginationUseCase;
import trim.api.domains.freetalk.service.GetAllFreeTalkUseCase;
import trim.api.domains.freetalk.service.GetHotFreeTalksUseCase;
import trim.api.domains.freetalk.service.GetSpecificFreeTalkUseCase;
import trim.api.domains.freetalk.vo.response.FreeTalkDetailResponse;
import trim.api.domains.freetalk.vo.response.FreeTalkListResponse;
import trim.api.domains.freetalk.vo.response.FreeTalkSummaryResponse;

import java.util.List;

import static trim.common.util.StaticValues.HOT_ISSUE_COUNT;

@Tag(name = "[자유 게시판]")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/access/free-talks")
public class FreeTalkAccessApiController {

    private final GetAllFreeTalkUseCase getAllFreeTalkUseCase;
    private final GetSpecificFreeTalkUseCase getSpecificFreeTalkUseCase;
    private final GetAllFreeTalkByPaginationUseCase getAllFreeTalkByPaginationUseCase;
    private final GetHotFreeTalksUseCase getHotFreeTalksUseCase;

    @Operation(summary = "자유 게시판 글을 모두 조회합니다. 이때 조회 형식은 요약본입니다.")
    @GetMapping
    public ApiResponseDto<List<FreeTalkSummaryResponse>> getAllFreeTalk() {
        return ApiResponseDto.onSuccess(getAllFreeTalkUseCase.execute());
    }

    @Operation(summary = "특정 자유 게시판을 조회합니다.")
    @GetMapping("/{freeTalkId}")
    public ApiResponseDto<FreeTalkDetailResponse> getSpecificFreeTalk(@PathVariable Long freeTalkId) {
        return ApiResponseDto.onSuccess(getSpecificFreeTalkUseCase.execute(freeTalkId));
    }

    @Operation(summary = "자유 게시판 글을 모두 조회합니다. 이때 페이지네이션을 통해 n만큼의 개수만을 불러올 수 있습니다.")
    @GetMapping("/page")
    public ApiResponseDto<FreeTalkListResponse> getAllFreeTalkByPagination(
            @RequestParam(defaultValue = "0") int currentPage,
            @RequestParam int pageSize) {
        Pageable pageable = PageRequest.of(currentPage, pageSize, PageUtil.LATEST_SORTING);
        return ApiResponseDto.onSuccess(getAllFreeTalkByPaginationUseCase.execute(pageable));
    }

    @Operation(summary = "자유 게시판의 인기 게시글 6개를 조회합니다.")
    @GetMapping("/hot-issue")
    public ApiResponseDto<List<FreeTalkSummaryResponse>> getHotFreeTalks() {
        Pageable pageable = PageRequest.of(0, HOT_ISSUE_COUNT);
        return ApiResponseDto.onSuccess(getHotFreeTalksUseCase.execute(pageable));
    }
}
