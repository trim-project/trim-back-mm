package trim.api.comment.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.comment.service.CreateQuestionCommentUseCase;
import trim.api.comment.service.DeleteQuestionCommentUseCase;
import trim.domains.comment.dto.request.CreateQuestionCommentRequest;
import trim.domains.member.domain.Member;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/{questionId}/questionComment")
public class QuestionCommentApiController {

    private final CreateQuestionCommentUseCase createQuestionCommentUseCaseUseCase;
    private final DeleteQuestionCommentUseCase deleteQuestionCommentUseCase;

    @PostMapping("/")
    public Long createQuestionComment(Member writer,
                                      @PathVariable("questionId") Long questionId,
                                      @RequestBody CreateQuestionCommentRequest dto){

        return createQuestionCommentUseCaseUseCase.execute(writer, questionId, dto);
    }

    @DeleteMapping("/{questionCommentId}")
    public void deleteQuestionComment(Member writer,
                                      @PathVariable("questionCommentId") Long questionCommentId){
        deleteQuestionCommentUseCase.execute(writer, questionCommentId);
    }

}
