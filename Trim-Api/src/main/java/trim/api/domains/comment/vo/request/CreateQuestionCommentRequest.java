package trim.api.domains.comment.vo.request;

import lombok.Getter;
import trim.domains.comment.dao.domain.QuestionComment;
import trim.domains.member.dao.domain.Member;
import trim.domains.question.dao.domain.Question;

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
