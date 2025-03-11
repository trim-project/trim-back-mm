package trim.api.domains.board.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.api.domains.board.BoardMapper;
import trim.api.domains.member.mapper.MemberMapper;
import trim.api.domains.member.vo.response.MemberResponse;
import trim.domains.board.dao.domain.Board;
import trim.domains.member.dao.domain.Member;

@Getter
@Builder
@RequiredArgsConstructor
public class BoardSummaryResponse {

    private final BoardResponse boardResponse;
    private final MemberResponse memberResponse;
    private final Long likeCount;

    public static BoardSummaryResponse of(Board board, Member member, Long likeCount) {
        return BoardSummaryResponse.builder()
                .boardResponse(BoardMapper.INSTANCE.toBoardResponse(board))
                .memberResponse(MemberMapper.INSTANCE.toMemberResponse(member))
                .likeCount(likeCount)
                .build();
    }
}
