package trim.api.domains.freetalk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.freetalk.mapper.FreeTalkMapper;
import trim.api.domains.freetalk.vo.response.FreeTalkSummaryResponse;
import trim.api.domains.member.mapper.MemberMapper;
import trim.common.annotation.UseCase;
import trim.domains.board.business.adaptor.FreeTalkAdaptor;
import trim.domains.board.dao.domain.FreeTalk;
import trim.domains.comment.business.adaptor.CommentAdaptor;
import trim.domains.like.business.adaptor.LikeAdaptor;

import java.util.List;

@UseCase
@Transactional
@RequiredArgsConstructor
public class GetAllFreeTalkByPaginationUseCase {

    private final FreeTalkAdaptor freeTalkAdaptor;
    private final CommentAdaptor commentAdaptor;
    private final LikeAdaptor likeAdaptor;

    public List<FreeTalkSummaryResponse> execute(Pageable pageable) {
        Page<FreeTalk> freeTalks = freeTalkAdaptor.queryAllFreeTalk(pageable);
        return freeTalks.getContent().stream()
                .map(this::mapToFreeTalkSummaryResponse)
                .toList();
    }

    private FreeTalkSummaryResponse mapToFreeTalkSummaryResponse(FreeTalk freeTalk) {
        return FreeTalkSummaryResponse.builder()
                .freeTalkResponse(FreeTalkMapper.INSTANCE.toFreeTalkResponse(freeTalk))
                .memberResponse(MemberMapper.INSTANCE.toMemberResponse(freeTalk.getWriter()))
                .commentCount(commentAdaptor.queryCountByBoardId(freeTalk.getId()))
                .likeCount(likeAdaptor.queryCountByBoard(freeTalk.getId()))
                .build();
    }
}
