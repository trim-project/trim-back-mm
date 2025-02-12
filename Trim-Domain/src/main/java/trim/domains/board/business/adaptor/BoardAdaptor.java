package trim.domains.board.business.adaptor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import trim.domains.board.dao.domain.Board;

public interface BoardAdaptor {

    Page<Board> queryAllBoards(Pageable pageable);
}
