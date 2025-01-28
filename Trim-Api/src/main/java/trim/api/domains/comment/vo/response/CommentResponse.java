package trim.api.domains.comment.vo.response;

import lombok.Builder;
import lombok.Getter;
import trim.domains.comment.dao.domain.Comment;

@Getter
@Builder
public class CommentResponse {
    private String content;
    private String nickname;

    public static CommentResponse of(Comment comment){
       return CommentResponse.builder()
               .content(comment.getContent())
               .nickname(comment.getWriter().getNickname())
               .build();
    }
}
