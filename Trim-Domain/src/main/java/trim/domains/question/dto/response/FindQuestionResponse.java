package trim.domains.question.dto.response;

import lombok.Builder;
import lombok.Data;
import trim.domains.member.domain.Member;
import trim.domains.question.domain.Question;

@Data
@Builder
public class FindQuestionResponse {
    private String title;
    private String content;
    private String author;


    public static FindQuestionResponse of(Question question) {
        return FindQuestionResponse.builder()
                .title(question.getTitle())
                .content(question.getContent())
                .build();
    }

}
