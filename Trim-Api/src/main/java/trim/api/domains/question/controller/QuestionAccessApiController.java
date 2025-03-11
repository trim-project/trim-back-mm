package trim.api.domains.question.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.common.util.PageUtil;
import trim.api.domains.question.service.*;
import trim.api.domains.question.vo.response.QuestionDetailResponse;
import trim.api.domains.question.vo.response.QuestionListResponse;
import trim.api.domains.question.vo.response.QuestionSummaryResponse;
import trim.common.annotation.RequestParamList;

import java.util.List;

import static trim.common.util.StaticValues.HOT_ISSUE_COUNT;

@Slf4j
@Tag(name = "[질문 게시판🔑]")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/access/questions")
public class QuestionAccessApiController {

    private final GetSpecificQuestionUseCase getSpecificQuestionUseCase;
    private final GetAllQuestionUseCase getAllQuestionUseCase;
    private final GetAllQuestionByPaginationUseCase getAllQuestionByPaginationUseCase;
    private final GetHotQuestionsUseCase getHotQuestionsUseCase;
    private final SearchQuestionsUseCase searchQuestionsUseCase;

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

    @Operation(summary = "질문 게시판을 모두 조회합니다. 이때 페이지네이션을 통해 n만큼의 개수만을 불러올 수 있습니다.")
    @GetMapping("/page")
    public ApiResponseDto<QuestionListResponse> getAllQuestionByPagination(
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

    @Operation(summary = "질문 게시글을 검색합니다. 이때 사용되는 항목은 학과 계열과 키워드 리스트입니다" +
            "키워드 리스트는 태그, 제목, 컨텐츠의 내용을 확인합니다.")
    @GetMapping("/search")
    public ApiResponseDto<QuestionListResponse> searchQuestions(@RequestParam(required = false) String majorType,
                                                                @Nullable @RequestParamList(value = "keyword") List<String> keyword,
                                                                @RequestParam(defaultValue = "0") int currentPage,
                                                                @RequestParam int pageSize) {
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        return ApiResponseDto.onSuccess(searchQuestionsUseCase.execute(majorType, keyword, pageable));
    }
}
