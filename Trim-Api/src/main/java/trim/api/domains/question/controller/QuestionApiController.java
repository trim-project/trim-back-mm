package trim.api.domains.question.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.question.service.EditQuestionUseCase;
import trim.api.domains.question.service.WriteQuestionUseCase;
import trim.api.domains.question.vo.request.QuestionRequest;
import trim.common.annotation.AuthUser;
import trim.domains.member.dao.domain.Member;

@Slf4j
@Tag(name = "[질문 게시판🔑]")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/questions")
public class QuestionApiController {

    private final WriteQuestionUseCase writeQuestionUseCase;
    private final EditQuestionUseCase editQuestionUseCase;


    @Operation(summary = "질문 게시판 작성 메서드입니다.")
    @PostMapping
    public ApiResponseDto<Long> createQuestion(@Parameter(hidden = true) @AuthUser Member member,
                                               @RequestBody QuestionRequest request) {
        return ApiResponseDto.onSuccess(writeQuestionUseCase.execute(member, request));

    }


    @Operation(summary = "질문 게시판 수정 메서드입니다. 작성자가 질문 게시판 pk를 통해 수정을 할 수 있습니다.")
    @PatchMapping("/{questionId}")
    public ApiResponseDto<Boolean> updateQuestion(@Parameter(hidden = true) @AuthUser Member member,
                                                  @PathVariable Long questionId,
                                                  @RequestBody QuestionRequest request) {
        editQuestionUseCase.execute(member, questionId, request);
        return ApiResponseDto.onSuccess(true);
    }

}
