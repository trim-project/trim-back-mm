package trim.api.domains.comment.vo.response;

import lombok.Builder;
import lombok.Getter;
import trim.domains.comment.dao.domain.Comment;

@Getter
@Builder
public class CommentResponse {
    private Long boardId;
    private Long commentId;
    private String content;
}
