package trim.api.domains.question.vo.response;

import lombok.Builder;
import lombok.Getter;
import trim.api.domains.comment.vo.response.CommentResponse;
import trim.domains.board.dao.domain.Question;
import trim.domains.board.dao.domain.ResolveStatus;
import trim.domains.comment.dao.domain.Comment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Builder
public class QuestionResponse {
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private ResolveStatus resolveStatus;
}
