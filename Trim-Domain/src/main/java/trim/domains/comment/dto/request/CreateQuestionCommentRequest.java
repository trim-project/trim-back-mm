package trim.domains.comment.dto.request;

import lombok.Getter;
import trim.domains.member.domain.Member;
import trim.domains.question.domain.Question;
import trim.domains.comment.domain.QuestionComment;

@Getter
public class CreateQuestionCommentRequest {
    private String content;

    public QuestionComment from(Member writer, Question question){
        return QuestionComment.builder()
                .content(this.getContent())
                .question(question)
                .writer(writer)
                .build();
    }
}
