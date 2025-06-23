package trim.api.domains.freetalk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.avatar.vo.response.stored.StoredAvatarResponse;
import trim.api.domains.freetalk.mapper.FreeTalkMapper;
import trim.api.domains.freetalk.vo.response.FreeTalkListResponse;
import trim.api.domains.freetalk.vo.response.FreeTalkSummaryResponse;
import trim.api.domains.member.mapper.MemberMapper;
import trim.common.annotation.UseCase;
import trim.domains.board.business.adaptor.FreeTalkAdaptor;
import trim.domains.board.dao.domain.FreeTalk;
import trim.domains.comment.business.adaptor.CommentAdaptor;
import trim.domains.like.business.adaptor.LikeAdaptor;

import java.util.List;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetAllFreeTalkByPaginationUseCase {

    private final FreeTalkAdaptor freeTalkAdaptor;
    private final CommentAdaptor commentAdaptor;
    private final LikeAdaptor likeAdaptor;

    public FreeTalkListResponse execute(Pageable pageable) {
        Page<FreeTalk> freeTalks = freeTalkAdaptor.queryAllFreeTalk(pageable);

        return FreeTalkListResponse.builder()
                .freeTalkResponseList(
                        freeTalks.getContent().stream()
                                .map(this::mapToFreeTalkSummaryResponse)
                                .toList())
                .page(freeTalks.getNumber())
                .totalPages(freeTalks.getTotalPages())
                .build();
    }

    private FreeTalkSummaryResponse mapToFreeTalkSummaryResponse(FreeTalk freeTalk) {
        return FreeTalkSummaryResponse.builder()
                .freeTalkResponse(FreeTalkMapper.INSTANCE.toFreeTalkResponse(freeTalk))
                .memberResponse(MemberMapper.INSTANCE.toMemberResponse(freeTalk.getWriter()))
                .storedAvatarResponse(StoredAvatarResponse.builder()
                        .backgroundColor(freeTalk.getWriter().getAvatar().getBackgroundColor())
                        .clothForURL(freeTalk.getWriter().getAvatar().getClothForURL())
                        .mouthForURL(freeTalk.getWriter().getAvatar().getMouthForURL())
                        .eyesForURL(freeTalk.getWriter().getAvatar().getEyesForURL())
                        .hairForURL(freeTalk.getWriter().getAvatar().getHairForURL())
                        .build())
                .commentCount(commentAdaptor.queryCountByBoardId(freeTalk.getId()))
                .likeCount(likeAdaptor.queryCountByBoard(freeTalk.getId()))
                .build();
    }
}
