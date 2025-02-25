package trim.api.domains.question.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.common.util.PageUtil;
import trim.api.domains.question.vo.request.QuestionRequest;
import trim.api.domains.question.vo.response.QuestionDetailResponse;
import trim.api.domains.question.service.*;
import trim.api.domains.question.vo.response.QuestionSummaryResponse;
import trim.common.util.StaticValues;


import java.util.List;

import static trim.common.util.StaticValues.HOT_ISSUE_COUNT;

@Tag(name = "[질문 게시판]")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/questions")
public class QuestionApiController {

    private final WriteQuestionUseCase writeQuestionUseCase;
    private final EditQuestionUseCase editQuestionUseCase;
    private final GetSpecificQuestionUseCase getSpecificQuestionUseCase;
    private final GetAllQuestionUseCase getAllQuestionUseCase;
    private final GetAllQuestionByPaginationUseCase getAllQuestionByPaginationUseCase;
    private final GetHotQuestionsUseCase getHotQuestionsUseCase;

    @Operation(summary = "질문 게시판 작성 메서드입니다.")
    @PostMapping("/members/{memberId}")
    public ApiResponseDto<Long> createQuestion(@PathVariable Long memberId, @RequestBody QuestionRequest request) {
        return ApiResponseDto.onSuccess(writeQuestionUseCase.execute(memberId, request));

    }

    @Operation(summary = "질문 게시판 조회 메서드입니다. 질문 게시판의 pk를 통해 조회합니다.")
    @GetMapping("/{questionId}")
    public ApiResponseDto<QuestionDetailResponse> getSpecificQuestion(@PathVariable Long questionId) {
        return ApiResponseDto.onSuccess(getSpecificQuestionUseCase.execute(questionId));
    }

    @Operation(summary = "질문 게시판 리스트 조회 메서드입니다.")
    @GetMapping
    public ApiResponseDto<List<QuestionSummaryResponse>> getAllQuestions() {
        return ApiResponseDto.onSuccess(getAllQuestionUseCase.execute());
    }

    @Operation(summary = "질문 게시판 수정 메서드입니다. 작성자가 질문 게시판 pk를 통해 수정을 할 수 있습니다.")
    @PostMapping("/{questionId}/members/{memberId}")
    public ApiResponseDto<Boolean> updateQuestion(@PathVariable Long memberId,
                                                  @PathVariable Long questionId,
                                                  @RequestBody QuestionRequest request) {
        editQuestionUseCase.execute(memberId, questionId, request);
        return ApiResponseDto.onSuccess(true);
    }

    @Operation(summary = "질문 게시판을 모두 조회합니다. 이때 페이지네이션을 통해 n만큼의 개수만을 불러올 수 있습니다.")
    @GetMapping("/page")
    public ApiResponseDto<List<QuestionSummaryResponse>> getAllQuestionByPagination(
            @RequestParam(defaultValue = "0") int currentPage,
            @RequestParam int pageSize
    ) {
        Pageable pageable = PageRequest.of(currentPage, pageSize, PageUtil.LATEST_SORTING);
        return ApiResponseDto.onSuccess(getAllQuestionByPaginationUseCase.execute(pageable));
    }

    @Operation(summary = "질문 게시판의 인기 게시글 6개를 조회합니다.")
    @GetMapping("/hot-issue")
    public ApiResponseDto<List<QuestionSummaryResponse>> getHotQuestions() {
        Pageable pageable = PageRequest.of(0, HOT_ISSUE_COUNT);
        return ApiResponseDto.onSuccess(getHotQuestionsUseCase.execute(pageable));
    }
}
