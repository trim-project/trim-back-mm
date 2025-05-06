package trim.api.domains.reply.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import trim.api.domains.reply.vo.ReplyResponse;
import trim.domains.board.dao.domain.Question;
import trim.domains.reply.dao.entity.Reply;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = false))
public interface ReplyMapper {

    ReplyMapper INSTANCE = Mappers.getMapper(ReplyMapper.class);

    @Mapping(target = "replyId", source = "reply.id")
    @Mapping(target = "createdAt", source = "reply.createdAt", qualifiedByName = "localDateTimeToLong")
    ReplyResponse toReplyResponse(Reply reply);
}
