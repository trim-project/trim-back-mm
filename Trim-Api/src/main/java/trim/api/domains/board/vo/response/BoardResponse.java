package trim.api.domains.board.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.domains.board.dao.domain.BoardType;

import java.time.LocalDate;

@Getter
@Builder
@RequiredArgsConstructor
public class BoardResponse {

    private final Long boardId;
    private final String title;
    private final LocalDate createdAt;
    private final BoardType boardType;
}
