package trim.api.domains.comment.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.comment.service.CreateQuestionCommentUseCase;
import trim.api.domains.comment.service.GetCommentsOfBoardUseCase;
import trim.api.domains.comment.vo.response.CommentResponse;

import java.util.List;

@Tag(name = "[댓글]")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentApiController {

    private final GetCommentsOfBoardUseCase getCommentsOfBoardUseCase;
    private final CreateQuestionCommentUseCase createQuestionCommentUseCaseUseCase;

    @Operation(summary = "게시글의 모든 댓글을 조회합니다. 이때 게시글은 PK로 조회합니다.")
    @GetMapping("/{boardId}")
    public ApiResponseDto<List<CommentDetailResponse>> getCommentsByBoardId(@PathVariable Long boardId) {
        return ApiResponseDto.onSuccess(getCommentsOfBoardUseCase.execute(boardId));
    }

    @Operation(summary = "질문 게시판의 댓글을 작성합니다.")
    @PostMapping("/questions/{questionId}/members/{memberId}")
    public ApiResponseDto<Long> createQuestionComment(@PathVariable Long memberId,
                                                      @PathVariable Long questionId,
                                                      @RequestBody String content) {
        return ApiResponseDto.onSuccess(createQuestionCommentUseCaseUseCase.execute(memberId, questionId, content));
    }
}
