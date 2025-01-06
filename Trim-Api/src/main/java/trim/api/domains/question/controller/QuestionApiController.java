package trim.api.domains.question.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.question.dto.request.QuestionRequest;
import trim.api.domains.question.dto.response.FindQuestionResponse;
import trim.api.domains.question.dto.response.QuestionResponse;
import trim.api.domains.question.service.*;
import trim.domains.member.domain.Member;


import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/questions")
public class QuestionApiController {

    private final CreateQuestionUseCase createQuestionUseCase;
    private final EditQuestionUseCase editQuestionUseCase;
    private final FindQuestionUseCase findQuestionUseCase;
    private final FindAllQuestionUseCase findAllQuestionUseCase;
    private final DeleteQuestionUseCase deleteQuestionUseCase;

    /** 질문 등록 - 테스트용 **/
    @PostMapping
    public ApiResponseDto<Long> createQuestion(Member writer, @RequestBody QuestionRequest request){
        return ApiResponseDto.onSuccess(createQuestionUseCase.execute(writer, request));

    }

    /** 질문 단일 조회 - 테스트용 **/
    @GetMapping("/{questionId}")
    public ApiResponseDto<QuestionResponse> findQuestion(@PathVariable Long questionId){
        return ApiResponseDto.onSuccess(findQuestionUseCase.execute(questionId));
    }

    /** 질문 전체 조회 - 테스트용 **/
    @GetMapping
    public ApiResponseDto<List<FindQuestionResponse>> findAllQuestions(){
        return ApiResponseDto.onSuccess(findAllQuestionUseCase.execute());
    }

    /** 질문 수정 - 테스트용 **/
    @PostMapping("/{questionId}")
    public ApiResponseDto<Boolean> updateQuestion(Member writer,
                               @PathVariable Long questionId,
                               @RequestBody QuestionRequest request){
        editQuestionUseCase.execute(writer, questionId, request);
        return ApiResponseDto.onSuccess(true);
    }

    /** 질문 삭제 - 테스트 용 **/
    @DeleteMapping("/{questionId}")
    public ApiResponseDto<Boolean> deleteQuestion(Member writer,
                               @PathVariable Long questionId){
        deleteQuestionUseCase.deleteQuestion(writer, questionId);
        return ApiResponseDto.onSuccess(true);
    }

}
