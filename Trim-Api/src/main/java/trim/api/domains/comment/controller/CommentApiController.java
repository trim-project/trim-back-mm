package trim.api.domains.comment.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.comment.service.WriteCommentUseCase;
import trim.api.domains.comment.vo.request.CommentRequest;

@Tag(name = "[댓글🔑]")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentApiController {

    private final WriteCommentUseCase writeCommentUseCase;

    @Operation(summary = "게시글의 댓글을 작성합니다. 이때 게시글의 타입은 신경쓰지 않습니다.")
    @PostMapping("/boards/{boardId}/members/{memberId}")
    public ApiResponseDto<Long> writeComment(@PathVariable Long boardId,
                                             @PathVariable Long memberId,
                                             @RequestBody CommentRequest request) {
        return ApiResponseDto.onSuccess(writeCommentUseCase.execute(memberId, boardId, request.getContent()));
    }


}
