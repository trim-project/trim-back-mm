package trim.api.domains.reply.vo;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@RequiredArgsConstructor
public class ReplyResponse {

    private final Long replyId;
    private final String content;
    private final Long createdAt;
}
