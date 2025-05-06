package trim.api.domains.reply.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import trim.api.common.util.EnumMappingUtil;
import trim.api.domains.reply.vo.ReplyResponse;
import trim.domains.board.dao.domain.Question;
import trim.domains.reply.dao.entity.Reply;

@Mapper(componentModel = "spring", uses = EnumMappingUtil.class, builder = @Builder(disableBuilder = false))
public interface ReplyMapper {

    ReplyMapper INSTANCE = Mappers.getMapper(ReplyMapper.class);

    @Mapping(target = "replyId", source = "reply.id")
    @Mapping(target = "createdAt", source = "reply.createdAt", qualifiedByName = "localDateTimeToLong")
    ReplyResponse toReplyResponse(Reply reply);
}
