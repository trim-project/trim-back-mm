package trim.api.domains.freetalk.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.freetalk.service.GetAllFreeTalkByPaginationUseCase;
import trim.api.domains.freetalk.service.GetAllFreeTalkUseCase;
import trim.api.domains.freetalk.service.GetSpecificFreeTalkUseCase;
import trim.api.domains.freetalk.service.WriteFreeTalkUseCase;
import trim.api.domains.freetalk.vo.response.FreeTalkDetailResponse;
import trim.api.domains.freetalk.vo.request.FreeTalkRequest;
import trim.api.domains.freetalk.vo.response.FreeTalkSummaryResponse;

import java.util.List;

@Tag(name = "[자유 게시판]")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/free-talks")
public class FreeTalkApiController {

    private final WriteFreeTalkUseCase writeFreeTalkUseCase;
    private final GetAllFreeTalkUseCase getAllFreeTalkUseCase;
    private final GetSpecificFreeTalkUseCase getSpecificFreeTalkUseCase;
    private final GetAllFreeTalkByPaginationUseCase getAllFreeTalkByPaginationUseCase;

    @Operation(summary = "자유 게시판 글을 작성합니다.")
    @PostMapping("/members/{memberId}")
    public ApiResponseDto<Long> writeFreeTalk(@PathVariable Long memberId,
                                              @RequestBody FreeTalkRequest request) {
        return ApiResponseDto.onSuccess(writeFreeTalkUseCase.execute(request, memberId));
    }

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
    public ApiResponseDto<List<FreeTalkSummaryResponse>> getAllFreeTalkByPagination(
            @RequestParam(defaultValue = "0") int currentPage,
            @RequestParam int pageSize) {
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        return ApiResponseDto.onSuccess(getAllFreeTalkByPaginationUseCase.execute(pageable));
    }
}
