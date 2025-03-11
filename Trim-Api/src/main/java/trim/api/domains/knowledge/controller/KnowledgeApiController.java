package trim.api.domains.knowledge.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.knowledge.service.*;
import trim.api.domains.knowledge.vo.request.KnowledgeRequest;
import trim.common.annotation.AuthUser;
import trim.domains.member.dao.domain.Member;

@Tag(name = "[지식 공유🔑]")
@RestController
@RequestMapping("/api/knowledge")
@RequiredArgsConstructor
public class KnowledgeApiController {

    private final WriteKnowledgeUseCase writeKnowledgeUseCase;

    @Operation(summary = "지식 공유 게시글을 작성합니다.")
    @PostMapping
    public ApiResponseDto<Long> writeKnowledge(@AuthUser Member member,
                                               @RequestBody KnowledgeRequest request) {
        return ApiResponseDto.onSuccess(writeKnowledgeUseCase.execute(member, request));
    }
}
