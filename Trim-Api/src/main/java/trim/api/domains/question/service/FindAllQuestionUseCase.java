package trim.api.domains.question.service;

import lombok.RequiredArgsConstructor;
import trim.api.domains.question.dto.response.FindQuestionResponse;
import trim.common.annotation.UseCase;
import trim.domains.question.adaptor.QuestionAdaptor;
import trim.domains.question.domain.Question;


import java.util.List;
import java.util.stream.Collectors;

@UseCase
@RequiredArgsConstructor
public class FindAllQuestionUseCase {
    private final QuestionAdaptor questionAdaptor;

    public List<FindQuestionResponse> execute(){
        List<Question> questions = questionAdaptor.queryAll();
        return questions.stream()
                .map(q -> FindQuestionResponse.of(q))
                .collect(Collectors.toList());
    }

}
