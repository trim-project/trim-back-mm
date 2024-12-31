package trim.api.domains.question.dto.response;

import lombok.Builder;
import lombok.Getter;
import trim.api.domains.comment.vo.response.QuestionCommentResponse;
import trim.domains.comment.domain.QuestionComment;
import trim.domains.question.domain.Question;

import java.util.List;
import java.util.stream.Collectors;


@Getter
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
