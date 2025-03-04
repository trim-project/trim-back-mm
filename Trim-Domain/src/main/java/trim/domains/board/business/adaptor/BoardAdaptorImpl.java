package trim.domains.board.business.adaptor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import trim.common.annotation.Adaptor;
import trim.domains.board.dao.domain.Board;
import trim.domains.board.dao.repository.jpa.BoardRepository;

@Adaptor
@RequiredArgsConstructor
public class BoardAdaptorImpl implements BoardAdaptor{

    private final BoardRepository boardRepository;
    @Override
    public Page<Board> queryAllBoards(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }
}
