package trim.api.domains.comment.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.comment.service.WriteFreeTalkCommentUseCase;
import trim.api.domains.comment.service.WriteQuestionCommentUseCase;
import trim.api.domains.comment.service.GetCommentsOfBoardUseCase;
import trim.api.domains.comment.vo.response.CommentDetailResponse;

import java.util.List;

@Tag(name = "[댓글]")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentApiController {

    private final GetCommentsOfBoardUseCase getCommentsOfBoardUseCase;
    private final WriteQuestionCommentUseCase writeQuestionCommentUseCase;
    private final WriteFreeTalkCommentUseCase writeFreeTalkCommentUseCase;

    @Operation(summary = "게시글의 모든 댓글을 조회합니다. 이때 게시글은 PK로 조회합니다.")
    @GetMapping("/{boardId}")
    public ApiResponseDto<List<CommentDetailResponse>> getCommentsOfBoard(@PathVariable Long boardId) {
        return ApiResponseDto.onSuccess(getCommentsOfBoardUseCase.execute(boardId));
    }

    @Operation(summary = "질문 게시판의 댓글을 작성합니다.")
    @PostMapping("/questions/{questionId}/members/{memberId}")
    public ApiResponseDto<Long> writeQuestionComment(@PathVariable Long memberId,
                                                      @PathVariable Long questionId,
                                                      @RequestBody String content) {
        return ApiResponseDto.onSuccess(writeQuestionCommentUseCase.execute(memberId, questionId, content));
    }
    @Operation(summary = "자유 게시판의 댓글을 작성합니다.")
    @PostMapping("/free-talks/{freeTalkId}/members/{memberId}")
    public ApiResponseDto<Long> writeFreeTalkComment(@PathVariable Long memberId,
                                                      @PathVariable Long freeTalkId,
                                                      @RequestBody String content) {
        return ApiResponseDto.onSuccess(writeFreeTalkCommentUseCase.execute(memberId, freeTalkId, content));
    }
}
