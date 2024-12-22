package trim.domains.question.dto;

import lombok.Builder;
import lombok.Data;
import trim.domains.member.domain.Member;
import trim.domains.question.domain.Question;

@Data
@Builder
public class QuestionDto {
    private String title;
    private String content;

    public Question from(Member member) {
        return Question.builder()
                .title(this.getTitle())
                .content(this.getContent())
                .writer(member)
                .build();
    }
}
