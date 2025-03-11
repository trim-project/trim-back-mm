package trim.api.domains.answer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.answer.service.WriteAnswerUseCase;
import trim.api.domains.answer.vo.AnswerRequest;
import trim.common.annotation.AuthUser;
import trim.domains.member.dao.domain.Member;

@Tag(name = "[답글 게시판🔑]")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/answers")
public class AnswerApiController {

    private final WriteAnswerUseCase writeAnswerUseCase;

    @Operation(summary = "질문 게시글의 답글 게시글을 작성합니다.")
    @PostMapping("/questions/{questionId}")
    public ApiResponseDto<Long> writeAnswer(@Parameter(hidden = true) @AuthUser Member member,
                                            @PathVariable Long questionId,
                                            @RequestBody AnswerRequest request) {
        return ApiResponseDto.onSuccess(writeAnswerUseCase.execute(questionId, member, request));
    }
}
