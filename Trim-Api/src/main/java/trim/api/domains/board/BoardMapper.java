package trim.api.domains.board;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import trim.api.domains.board.vo.response.BoardResponse;
import trim.domains.board.dao.domain.Board;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = false))
public interface BoardMapper {

    BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);

    @Mapping(target = "boardId", source = "board.id")
    BoardResponse toBoardResponse(Board board);
}
