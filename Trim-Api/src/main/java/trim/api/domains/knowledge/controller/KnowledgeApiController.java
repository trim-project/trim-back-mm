package trim.api.domains.knowledge.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.knowledge.service.GetAllKnowledgeByPaginationUseCase;
import trim.api.domains.knowledge.service.GetAllKnowledgeUseCase;
import trim.api.domains.knowledge.service.GetSpecificKnowledgeUseCase;
import trim.api.domains.knowledge.service.WriteKnowledgeUseCase;
import trim.api.domains.knowledge.vo.request.KnowledgeRequest;
import trim.api.domains.knowledge.vo.response.KnowledgeDetailResponse;
import trim.api.domains.knowledge.vo.response.KnowledgeSummaryResponse;

import java.util.List;

@Tag(name = "[지식 공유]")
@RestController
@RequestMapping("/api/knowledge")
@RequiredArgsConstructor
public class KnowledgeApiController {

    private final WriteKnowledgeUseCase writeKnowledgeUseCase;
    private final GetAllKnowledgeUseCase getAllKnowledgeUseCase;
    private final GetSpecificKnowledgeUseCase getSpecificKnowledgeUseCase;
    private final GetAllKnowledgeByPaginationUseCase getAllKnowledgeByPaginationUseCase;

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
    public ApiResponseDto<List<KnowledgeSummaryResponse>> getAllKnowledgeByPagination(
            @RequestParam(defaultValue = "0") int currentPage,
            @RequestParam int pageSize
    ) {
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        return ApiResponseDto.onSuccess(getAllKnowledgeByPaginationUseCase.execute(pageable));
    }
}
