package trim.api.domains.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.board.vo.response.BoardSummaryResponse;
import trim.common.annotation.UseCase;
import trim.domains.board.business.adaptor.BoardAdaptor;
import trim.domains.board.dao.domain.Board;
import trim.domains.like.business.adaptor.LikeAdaptor;

import java.util.List;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetAllBoardsByPaginationUseCase {

    private final BoardAdaptor boardAdaptor;
    private final LikeAdaptor likeAdaptor;

    public List<BoardSummaryResponse> execute(Pageable pageable) {
        Page<Board> boards = boardAdaptor.queryAllBoards(pageable);
        return boards.getContent().stream()
                .map(board ->
                        BoardSummaryResponse.of(board, board.getWriter(), likeAdaptor.queryCountByBoard(board.getId())))
                .toList();
    }
}
