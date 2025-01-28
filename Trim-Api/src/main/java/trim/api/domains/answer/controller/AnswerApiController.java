package trim.api.domains.answer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.answer.service.WriteAnswerUseCase;
import trim.api.domains.answer.vo.AnswerRequest;

@Tag(name = "[답글 게시판]")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/answers")
public class AnswerApiController {

    private final WriteAnswerUseCase writeAnswerUseCase;

    @Operation(summary = "질문 게시글의 답글 게시글을 작성합니다.")
    @PostMapping("/questions/{questionId}/members/{memberId}")
    public ApiResponseDto<Long> writeAnswer(@PathVariable Long questionId,
                                            @PathVariable Long memberId,
                                            @RequestBody AnswerRequest request) {
        return ApiResponseDto.onSuccess(writeAnswerUseCase.execute(questionId, memberId, request));
    }
}
