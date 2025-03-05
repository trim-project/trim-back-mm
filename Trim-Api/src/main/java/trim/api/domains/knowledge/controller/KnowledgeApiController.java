package trim.api.domains.knowledge.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.common.util.PageUtil;
import trim.api.domains.knowledge.service.*;
import trim.api.domains.knowledge.vo.request.KnowledgeRequest;
import trim.api.domains.knowledge.vo.response.KnowledgeDetailResponse;
import trim.api.domains.knowledge.vo.response.KnowledgeListResponse;
import trim.api.domains.knowledge.vo.response.KnowledgeSummaryResponse;

import java.util.List;

import static trim.common.util.StaticValues.HOT_ISSUE_COUNT;

@Tag(name = "[지식 공유]")
@RestController
@RequestMapping("/api/knowledge")
@RequiredArgsConstructor
public class KnowledgeApiController {

    private final WriteKnowledgeUseCase writeKnowledgeUseCase;
    private final GetAllKnowledgeUseCase getAllKnowledgeUseCase;
    private final GetSpecificKnowledgeUseCase getSpecificKnowledgeUseCase;
    private final GetAllKnowledgeByPaginationUseCase getAllKnowledgeByPaginationUseCase;
    private final GetHotKnowledgeUseCase getHotKnowledgeUseCase;
    private final SearchKnowledgeUseCase searchKnowledgeUseCase;

    @Operation(summary = "지식 공유 게시글을 작성합니다.")
    @PostMapping("/members/{memberId}")
    public ApiResponseDto<Long> writeKnowledge(@PathVariable Long memberId,
                                               @RequestBody KnowledgeRequest request) {
        return ApiResponseDto.onSuccess(writeKnowledgeUseCase.execute(memberId, request));
    }

    @Operation(summary = "지식 공유 게시글을 모두 조회합니다. 이때 형식은 요약입니다.")
    @GetMapping
    public ApiResponseDto<List<KnowledgeSummaryResponse>> getAllKnowledge() {
        return ApiResponseDto.onSuccess(getAllKnowledgeUseCase.execute());
    }

    @Operation(summary = "특정 지식 공유 게시글을 조회합니다.")
    @GetMapping("/{knowledgeId}")
    public ApiResponseDto<KnowledgeDetailResponse> getSpecificKnowledge(@PathVariable Long knowledgeId) {
        return ApiResponseDto.onSuccess(getSpecificKnowledgeUseCase.execute(knowledgeId));
    }

    @Operation(summary = "지식 공유 게시글을 모두 조회합니다. 이때 페이지네이션을 통해 n만큼의 개수만을 불러올 수 있습니다.")
    @GetMapping("/page")
    public ApiResponseDto<KnowledgeListResponse> getAllKnowledgeByPagination(
            @RequestParam(defaultValue = "0") int currentPage,
            @RequestParam int pageSize
    ) {
        Pageable pageable = PageRequest.of(currentPage, pageSize, PageUtil.LATEST_SORTING);
        return ApiResponseDto.onSuccess(getAllKnowledgeByPaginationUseCase.execute(pageable));
    }

    @Operation(summary = "지식 공유 게시판의 인기 게시글 6개를 조회합니다.")
    @GetMapping("/hot-issue")
    public ApiResponseDto<List<KnowledgeSummaryResponse>> getHotKnowledge() {
        Pageable pageable = PageRequest.of(0, HOT_ISSUE_COUNT);
        return ApiResponseDto.onSuccess(getHotKnowledgeUseCase.execute(pageable));
    }

    @Operation(summary = "지식공유 게시글을 검색합니다. 이때 사용되는 항목은 학과 계열과 키워드 리스트입니다" +
            "키워드 리스트는 태그, 제목, 컨텐츠의 내용을 확인합니다.")
    @GetMapping("/search")
    public ApiResponseDto<KnowledgeListResponse> searchKnowledge(@RequestParam String majorType,
                                                                 @RequestParam List<String> keyword,
                                                                 @RequestParam(defaultValue = "0") int currentPage,
                                                                 @RequestParam int pageSize) {

        Pageable pageable = PageRequest.of(currentPage, pageSize, PageUtil.LATEST_SORTING);
        return ApiResponseDto.onSuccess(searchKnowledgeUseCase.execute(majorType, keyword, pageable));
    }
}
