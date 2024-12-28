package trim.api.question.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.question.service.CreateQuestionUseCase;
import trim.api.question.service.FindAllQuestionUseCase;
import trim.api.question.service.FindQuestionUseCase;
import trim.api.question.service.EditQuestionUseCase;
import trim.domains.member.domain.Member;
import trim.domains.question.dto.request.CreateQuestionRequest;
import trim.domains.question.dto.request.EditQuestionRequest;
import trim.domains.question.dto.response.FindQuestionResponse;
import trim.domains.question.dto.response.QuestionResponse;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/question")
public class QuestionApiController {

    private final CreateQuestionUseCase createQuestionUseCase;
    private final EditQuestionUseCase editQuestionUseCase;
    private final FindQuestionUseCase findQuestionUseCase;
    private final FindAllQuestionUseCase findAllQuestionUseCase;

    /** 질문 등록 - 테스트용 **/
    @PostMapping("/")
    public Long createQuestion(Member writer, @RequestBody CreateQuestionRequest request){
        return createQuestionUseCase.execute(writer, request);

    }

    /** 질문 단일 조회 - 테스트용 **/
    @GetMapping("/{id}")
    public QuestionResponse findQuestion(@PathVariable("id") Long questionId){
        return findQuestionUseCase.execute(questionId);
    }

    /** 질문 전체 조회 - 테스트용 **/
    @GetMapping("/")
    public List<FindQuestionResponse> findAllQuestions(){
        return findAllQuestionUseCase.execute();
    }

    /** 질문 수정 - 테스트용 **/
    @PostMapping("/{id}")
    public void updateQuestion(Member writer,
                               @PathVariable("id") Long questionId,
                               @RequestBody EditQuestionRequest request){
        editQuestionUseCase.execute(writer, questionId, request);
    }



}
