package trim.api.domains.comment.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.comment.service.GetCommentsOfBoardUseCase;
import trim.api.domains.comment.vo.response.CommentResponse;

import java.util.List;

@Tag(name = "[댓글]")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentApiController {

    private final GetCommentsOfBoardUseCase getCommentsOfBoardUseCase;

    @GetMapping("/{boardId}")
    public ApiResponseDto<List<CommentResponse>> getCommentsByBoardId(@PathVariable Long boardId) {
        return ApiResponseDto.onSuccess(getCommentsOfBoardUseCase.execute(boardId));
    }
}
