package trim.api.question.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trim.api.question.model.request.CreateQuestionRequest;
import trim.api.question.model.response.CreateQuestionResponse;
import trim.api.question.service.CreateQuestionUseCase;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/question")
public class QuestionApiController {

    private final CreateQuestionUseCase createQuestionUseCase;

    @PostMapping("/")
    public CreateQuestionResponse createQuestion(@RequestBody CreateQuestionRequest createQuestionRequest){
        return createQuestionRequest.

    }

}
