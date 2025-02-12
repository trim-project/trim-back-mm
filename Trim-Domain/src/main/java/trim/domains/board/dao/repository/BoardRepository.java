package trim.domains.board.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trim.domains.board.dao.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
