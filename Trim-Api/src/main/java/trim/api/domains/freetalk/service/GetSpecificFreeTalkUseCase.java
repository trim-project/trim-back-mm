package trim.api.domains.freetalk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.comment.mapper.CommentMapper;
import trim.api.domains.comment.vo.response.CommentDetailResponse;
import trim.api.domains.freetalk.mapper.FreeTalkMapper;
import trim.api.domains.freetalk.vo.FreeTalkDetailResponse;
import trim.api.domains.freetalk.vo.FreeTalkResponse;
import trim.api.domains.member.mapper.MemberMapper;
import trim.common.annotation.UseCase;
import trim.domains.board.business.adaptor.FreeTalkAdaptor;
import trim.domains.board.dao.domain.FreeTalk;
import trim.domains.comment.business.adaptor.CommentAdaptor;
import trim.domains.comment.dao.domain.Comment;

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
