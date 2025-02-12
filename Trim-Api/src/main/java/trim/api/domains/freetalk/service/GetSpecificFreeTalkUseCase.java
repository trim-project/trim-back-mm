package trim.api.domains.freetalk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.freetalk.vo.response.FreeTalkDetailResponse;
import trim.common.annotation.UseCase;
import trim.domains.board.business.adaptor.FreeTalkAdaptor;
import trim.domains.board.dao.domain.FreeTalk;
import trim.domains.comment.business.adaptor.CommentAdaptor;
import trim.domains.comment.dao.domain.Comment;
import trim.domains.like.business.adaptor.LikeAdaptor;

import java.util.List;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetSpecificFreeTalkUseCase {

    private final FreeTalkAdaptor freeTalkAdaptor;
    private final CommentAdaptor commentAdaptor;

    public FreeTalkDetailResponse execute(Long freeTalkId) {
        FreeTalk freeTalk = freeTalkAdaptor.queryFreeTalkById(freeTalkId);
        List<Comment> comments = commentAdaptor.queryAllByBoardId(freeTalkId);
        return FreeTalkDetailResponse.of(freeTalk, comments);
    }
}
