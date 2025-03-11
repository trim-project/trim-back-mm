package trim.api.domains.knowledge.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.knowledge.service.*;
import trim.api.domains.knowledge.vo.request.KnowledgeRequest;

@Tag(name = "[지식 공유🔑]")
@RestController
@RequestMapping("/api/knowledge")
@RequiredArgsConstructor
public class KnowledgeApiController {

    private final WriteKnowledgeUseCase writeKnowledgeUseCase;

    @Operation(summary = "지식 공유 게시글을 작성합니다.")
    @PostMapping("/members/{memberId}")
    public ApiResponseDto<Long> writeKnowledge(@PathVariable Long memberId,
                                               @RequestBody KnowledgeRequest request) {
        return ApiResponseDto.onSuccess(writeKnowledgeUseCase.execute(memberId, request));
    }
}
