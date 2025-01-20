package trim.domains.board.business.validate;

import trim.domains.board.dao.domain.Board;
import trim.domains.board.dao.domain.BoardType;
import trim.domains.board.dao.domain.Question;
import trim.domains.member.dao.domain.Member;

public interface BoardValidate {

    void checkIsWriter(Member member, Board board);

    void canDelete(Member member, Board board);

    void checkBoardType(Board board, BoardType boardType);

}
