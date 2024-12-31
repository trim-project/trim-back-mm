package trim.api.domains.question.dto.response;

import lombok.Builder;
import lombok.Getter;
import trim.domains.question.domain.Question;

@Getter
@Builder
public class FindQuestionResponse {
    private String title;
    private String nickname;

    public static FindQuestionResponse of(Question question){
        return FindQuestionResponse.builder()
                .title(question.getTitle())
                .nickname(question.getWriter().getNickname())
                .build();
    }
}
