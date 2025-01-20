package trim.api.domains.comment.vo.response;

import lombok.Builder;
import lombok.Getter;
import trim.domains.comment.dao.domain.Comment;

@Getter
@Builder
public class QuestionCommentResponse {
    private String content;
    private String nickname;

    public static QuestionCommentResponse of(Comment comment){
       return QuestionCommentResponse.builder()
               .content(comment.getContent())
               .nickname(comment.getWriter().getNickname())
               .build();
    }
}
