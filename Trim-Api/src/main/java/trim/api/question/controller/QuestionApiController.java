package trim.api.question.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trim.api.question.service.CreateQuestionUseCase;
import trim.domains.member.domain.Member;
import trim.domains.question.dto.request.CreateQuestionRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/question")
public class QuestionApiController {

    private final CreateQuestionUseCase createQuestionUseCase;

    /** 질문 등록 - 테스트용 **/
    @PostMapping("/")
    public Long createQuestion(Member writer, @RequestBody CreateQuestionRequest createQuestionRequest){
        return createQuestionUseCase.execute(writer, createQuestionRequest);

    }

}
