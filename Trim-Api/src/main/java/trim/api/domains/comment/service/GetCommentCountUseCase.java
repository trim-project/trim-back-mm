package trim.api.domains.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.comment.business.adaptor.CommentAdaptor;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetCommentCountUseCase {

    private final CommentAdaptor commentAdaptor;

    public Long execute(Long boardId) {
        return commentAdaptor.queryCountByBoardId(boardId);
    }
}
