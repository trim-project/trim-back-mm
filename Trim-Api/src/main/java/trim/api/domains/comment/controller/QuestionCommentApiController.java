package trim.api.domains.comment.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.comment.service.CreateQuestionCommentUseCase;
import trim.domains.member.dao.domain.Member;

@Tag(name = "[질문 댓글 게시판]")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/questions/{questionId}/comments")
public class QuestionCommentApiController {

    private final CreateQuestionCommentUseCase createQuestionCommentUseCaseUseCase;

    /**
     * 댓글 등록 테스트용
     **/
    @PostMapping("/members/{memberId}")
    public ApiResponseDto<Long> createQuestionComment(@PathVariable Long memberId,
                                                      @PathVariable Long questionId,
                                                      @RequestBody String content) {
        return ApiResponseDto.onSuccess(createQuestionCommentUseCaseUseCase.execute(memberId, questionId, content));
    }

}
