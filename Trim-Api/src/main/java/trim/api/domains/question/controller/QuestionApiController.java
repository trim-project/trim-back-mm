package trim.api.domains.question.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.question.vo.request.QuestionRequest;
import trim.api.domains.question.vo.response.QuestionDetailResponse;
import trim.api.domains.question.vo.response.QuestionResponse;
import trim.api.domains.question.service.*;
import trim.domains.member.dao.domain.Member;


import java.util.List;

@Tag(name = "[질문 게시판]")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/questions")
public class QuestionApiController {

    private final CreateQuestionUseCase createQuestionUseCase;
    private final EditQuestionUseCase editQuestionUseCase;
    private final FindSpecificQuestionUseCase findSpecificQuestionUseCase;
    private final FindAllQuestionUseCase findAllQuestionUseCase;

    @Operation(summary = "질문 게시판 작성 메서드입니다.")
    @PostMapping("/members/{memberId}")
    public ApiResponseDto<Long> createQuestion(@PathVariable Long memberId, @RequestBody QuestionRequest request){
        return ApiResponseDto.onSuccess(createQuestionUseCase.execute(memberId, request));

    }

    @Operation(summary = "질문 게시판 조회 메서드입니다. 질문 게시판의 pk를 통해 조회합니다.")
    @GetMapping("/{questionId}")
    public ApiResponseDto<QuestionDetailResponse> findQuestion(@PathVariable Long questionId){
        return ApiResponseDto.onSuccess(findSpecificQuestionUseCase.execute(questionId));
    }

    @Operation(summary = "질문 게시판 리스트 조회 메서드입니다.")
    @GetMapping
    public ApiResponseDto<List<QuestionDetailResponse>> findAllQuestions(){
        return ApiResponseDto.onSuccess(findAllQuestionUseCase.execute());
    }

    @Operation(summary = "질문 게시판 수정 메서드입니다. 작성자가 질문 게시판 pk를 통해 수정을 할 수 있습니다.")
    @PostMapping("/{questionId}/members/{memberId}")
    public ApiResponseDto<Boolean> updateQuestion(@PathVariable Long memberId,
                                                  @PathVariable Long questionId,
                                                  @RequestBody QuestionRequest request) {
        editQuestionUseCase.execute(memberId, questionId, request);
        return ApiResponseDto.onSuccess(true);
    }

}
