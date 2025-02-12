package trim.api.domains.comment.vo.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class CommentRequest {
    private final String content;
}
