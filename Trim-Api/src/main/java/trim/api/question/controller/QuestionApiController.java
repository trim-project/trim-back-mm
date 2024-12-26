package trim.api.question.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.question.service.CreateQuestionUseCase;
import trim.api.question.service.FindQuestionUseCase;
import trim.domains.member.domain.Member;
import trim.domains.question.dto.request.CreateQuestionRequest;
import trim.domains.question.dto.response.FindQuestionResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/question")
public class QuestionApiController {

    private final CreateQuestionUseCase createQuestionUseCase;
    private final FindQuestionUseCase findQuestionUseCase;

    /** 질문 등록 - 테스트용 **/
    @PostMapping("/")
    public Long createQuestion(Member writer, @RequestBody CreateQuestionRequest createQuestionRequest){
        return createQuestionUseCase.execute(writer, createQuestionRequest);

    }

    /** 질문 단일 조회 - 테스트용 **/
    @GetMapping("/{id}")
    public FindQuestionResponse findQuestion(@PathVariable("id") Long questionId){
        return findQuestionUseCase.execute(questionId);
    }


}
