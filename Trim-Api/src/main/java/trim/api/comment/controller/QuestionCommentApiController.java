package trim.api.comment.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.comment.service.CreateQuestionCommentUseCase;
import trim.domains.comment.dto.request.CreateQuestionCommentRequest;
import trim.domains.member.domain.Member;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/questionComment")
public class QuestionCommentApiController {

    private final CreateQuestionCommentUseCase createQuestionCommentUseCaseUseCase;

    @PostMapping("/{questionId}")
    public Long createQuestionComment(Member writer,
                                      @PathVariable("questionId") Long questionId,
                                      @RequestBody CreateQuestionCommentRequest dto){

        return createQuestionCommentUseCaseUseCase.execute(writer, questionId, dto);
    }

}
