package trim.api.comment.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.comment.service.CreateQuestionCommentUseCase;
import trim.api.comment.service.DeleteQuestionCommentUseCase;
import trim.api.comment.vo.request.CreateQuestionCommentRequest;
import trim.domains.member.domain.Member;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/questions/{questionId}/comments")
public class QuestionCommentApiController {

    private final CreateQuestionCommentUseCase createQuestionCommentUseCaseUseCase;
    private final DeleteQuestionCommentUseCase deleteQuestionCommentUseCase;
    
    /** 댓글 등록 테스트용 **/
    @PostMapping
    public Long createQuestionComment(Member writer,
                                      @PathVariable("questionId") Long questionId,
                                      @RequestBody CreateQuestionCommentRequest dto){

        return createQuestionCommentUseCaseUseCase.execute(writer, questionId, dto);
    }

    /** 댓글 삭제 테스트용 **/
    @DeleteMapping("/{commentId}")
    public void deleteQuestionComment(Member writer,
                                      @PathVariable("commentId") Long commentId){
        deleteQuestionCommentUseCase.execute(writer, commentId);
    }

}
