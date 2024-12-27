package trim.api.question.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.UseCase;
import trim.domains.question.adaptor.QuestionAdaptor;
import trim.domains.question.domain.Question;
import trim.domains.question.dto.response.FindAllQuestionResponse;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindAllQuestionUseCase {
    private final QuestionAdaptor questionAdaptor;

    public FindAllQuestionResponse execute(){
        List<Question> questions = questionAdaptor.queryAll();
        return FindAllQuestionResponse.of(questions);
    }

}
