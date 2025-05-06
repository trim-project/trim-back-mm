package trim.api.domains.reply.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.reply.service.GetAllReplyOfCommentUseCase;
import trim.api.domains.reply.vo.ReplyDetailResponse;

import java.util.List;

@Slf4j
@Tag(name = "[대댓글]")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/access/replies")
public class ReplyAccessController {

    private final GetAllReplyOfCommentUseCase getALlReplyOfCommentUseCase;

    @GetMapping("/comments/{commentId}")
    public ApiResponseDto<List<ReplyDetailResponse>> getAllReplyOfComment(@PathVariable Long commentId) {
        return ApiResponseDto.onSuccess(getALlReplyOfCommentUseCase.execute(commentId));
    }
}
