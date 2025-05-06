package trim.api.domains.reply.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.reply.service.WriteReplyOfCommentUseCase;
import trim.common.annotation.AuthUser;
import trim.domains.member.dao.domain.Member;

@Slf4j
@Tag(name = "[대댓글🔑]")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/replies")
public class ReplyApiController {

    private final WriteReplyOfCommentUseCase writeReplyOfCommentUseCase;

    @PostMapping("/comments/{commentId}")
    public ApiResponseDto<Long> writeReplyOfComment(@PathVariable Long commentId,
                                                    @Parameter(hidden = true) @AuthUser Member member,
                                                    @RequestParam String content) {
        return ApiResponseDto.onSuccess(writeReplyOfCommentUseCase.execute(commentId, member, content));
    }
}
