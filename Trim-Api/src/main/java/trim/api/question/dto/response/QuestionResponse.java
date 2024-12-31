package trim.api.question.dto.response;

import lombok.Builder;
import lombok.Data;
import trim.domains.comment.domain.QuestionComment;
import trim.domains.comment.dto.response.QuestionCommentResponse;
import trim.domains.question.domain.Question;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class QuestionResponse {
    private String title;
    private String content;
    private String nickname;

    private List<QuestionCommentResponse> questionComments;

    public static QuestionResponse of(Question question, List<QuestionComment> questionComments) {
        return QuestionResponse.builder()
                .title(question.getTitle())
                .content(question.getContent())
                .nickname(question.getWriter().getNickname())
                .questionComments(
                        questionComments.stream().map(
                                qc -> QuestionCommentResponse.of(qc)
                        ).collect(Collectors.toList())
                )
                .build();
    }

}
