package trim.api.domains.comment.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.comment.service.GetCommentCountUseCase;
import trim.api.domains.comment.service.GetCommentsOfBoardUseCase;
import trim.api.domains.comment.vo.response.CommentDetailResponse;

import java.util.List;

@Tag(name = "[댓글]")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/access/comments")
public class CommentAccessApiController {

    private final GetCommentsOfBoardUseCase getCommentsOfBoardUseCase;
    private final GetCommentCountUseCase getCommentCountUseCase;

    @Operation(summary = "게시글의 모든 댓글을 조회합니다. 이때 게시글은 PK로 조회합니다.")
    @GetMapping("/{boardId}")
    public ApiResponseDto<List<CommentDetailResponse>> getCommentsOfBoard(@PathVariable Long boardId) {
        return ApiResponseDto.onSuccess(getCommentsOfBoardUseCase.execute(boardId));
    }

    @Operation(summary = "게시글의 댓글 개수를 조회합니다. 주로 상세페이지에서 사용될 예정입니다.")
    @GetMapping("/boards/{boardId}")
    public ApiResponseDto<Long> getCommentCount(@PathVariable Long boardId) {
        return ApiResponseDto.onSuccess(getCommentCountUseCase.execute(boardId));
    }
}
