package trim.api.domains.comment.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.comment.service.CreateQuestionCommentUseCase;
import trim.api.domains.comment.service.DeleteQuestionCommentUseCase;
import trim.api.domains.comment.vo.request.CreateQuestionCommentRequest;
import trim.domains.member.domain.Member;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/questions/{questionId}/comments")
public class QuestionCommentApiController {

    private final CreateQuestionCommentUseCase createQuestionCommentUseCaseUseCase;
    private final DeleteQuestionCommentUseCase deleteQuestionCommentUseCase;
    
    /** 댓글 등록 테스트용 **/
    @PostMapping
    public ApiResponseDto<Long> createQuestionComment(Member writer,
                                                @PathVariable("questionId") Long questionId,
                                                @RequestBody CreateQuestionCommentRequest dto){

        return ApiResponseDto.onSuccess(createQuestionCommentUseCaseUseCase.execute(writer, questionId, dto));
    }

    /** 댓글 삭제 테스트용 **/
    @DeleteMapping("/{commentId}")
    public ApiResponseDto<Boolean> deleteQuestionComment(Member writer,
                                      @PathVariable("commentId") Long commentId){
        deleteQuestionCommentUseCase.execute(writer, commentId);
        return ApiResponseDto.onSuccess(true);
    }

}
