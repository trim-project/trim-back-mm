package trim.domains.question.dto.response;

import lombok.Builder;
import lombok.Getter;
import trim.domains.question.domain.Question;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class FindAllQuestionResponse {
    private final List<FindQuestionResponse> questions;

    public static FindAllQuestionResponse of(List<Question> questions){
        return FindAllQuestionResponse.builder()
                .questions(
                    questions.stream()
                            .map(q -> FindQuestionResponse.of(q))
                            .collect(Collectors.toList())
                )
                .build();
    }
}
