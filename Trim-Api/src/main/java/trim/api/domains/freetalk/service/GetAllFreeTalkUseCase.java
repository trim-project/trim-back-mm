package trim.api.domains.freetalk.service;

import lombok.RequiredArgsConstructor;
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
import java.util.stream.Collectors;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetAllFreeTalkUseCase {

    private final FreeTalkAdaptor freeTalkAdaptor;
    private final CommentAdaptor commentAdaptor;
    private final LikeAdaptor likeAdaptor;

    public List<FreeTalkSummaryResponse> execute() {
        List<FreeTalk> freeTalks = freeTalkAdaptor.queryAllFreeTalk();

        return freeTalks.stream()
                .map(this::mapToFreeTalkSummaryResponse)
                .collect(Collectors.toList());
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
