package trim.api.domains.comment.vo.response;

import lombok.Builder;
import lombok.Getter;
import trim.domains.comment.dao.domain.QuestionComment;

@Getter
@Builder
public class QuestionCommentResponse {
    private String content;
    private String nickname;

    public static QuestionCommentResponse of(QuestionComment questionComment){
       return QuestionCommentResponse.builder()
               .content(questionComment.getContent())
               .nickname(questionComment.getWriter().getNickname())
               .build();
    }
}
