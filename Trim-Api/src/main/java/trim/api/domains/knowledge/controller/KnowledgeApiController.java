package trim.api.domains.knowledge.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
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

    @Operation(summary = "특정 지식 공유 게시글을 조회합니다. 조회 시 지식 공유의 랜덤난수 키값이 필요합니다.")
    @GetMapping("/{knowledgeId}")
    public ApiResponseDto<KnowledgeDetailResponse> getSpecificKnowledge(@PathVariable Long knowledgeId) {
        return ApiResponseDto.onSuccess(getSpecificKnowledgeUseCase.execute(knowledgeId));
    }
}
