package trim.api.domains.question.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.question.service.*;
import trim.api.domains.question.vo.request.QuestionRequest;

@Slf4j
@Tag(name = "[질문 게시판🔑]")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/questions")
public class QuestionApiController {

    private final WriteQuestionUseCase writeQuestionUseCase;
    private final EditQuestionUseCase editQuestionUseCase;


    @Operation(summary = "질문 게시판 작성 메서드입니다.")
    @PostMapping("/members/{memberId}")
    public ApiResponseDto<Long> createQuestion(@AuthenticationPrincipal String username,
                                               @RequestBody QuestionRequest request) {
        return ApiResponseDto.onSuccess(writeQuestionUseCase.execute(username, request));

    }


    @Operation(summary = "질문 게시판 수정 메서드입니다. 작성자가 질문 게시판 pk를 통해 수정을 할 수 있습니다.")
    @PatchMapping("/{questionId}/members/{memberId}")
    public ApiResponseDto<Boolean> updateQuestion(@AuthenticationPrincipal String username,
                                                  @PathVariable Long questionId,
                                                  @RequestBody QuestionRequest request) {
        editQuestionUseCase.execute(username, questionId, request);
        return ApiResponseDto.onSuccess(true);
    }


}
