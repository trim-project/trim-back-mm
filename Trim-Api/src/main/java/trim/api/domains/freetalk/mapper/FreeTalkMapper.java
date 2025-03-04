package trim.api.domains.freetalk.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import trim.api.common.util.EnumMappingUtil;
import trim.api.domains.freetalk.vo.response.FreeTalkResponse;
import trim.domains.board.dao.domain.FreeTalk;

@Mapper(componentModel = "spring", uses = EnumMappingUtil.class, builder = @Builder(disableBuilder = false))
public interface FreeTalkMapper {

    FreeTalkMapper INSTANCE = Mappers.getMapper(FreeTalkMapper.class);

    @Mapping(target = "freeTalkId", source = "freeTalk.id")
    @Mapping(target = "title", source = "freeTalk.title")
    @Mapping(target = "content", source = "freeTalk.content")
    @Mapping(target = "createdAt", source = "freeTalk.createdAt", qualifiedByName = "localDateTimeToLong")
    FreeTalkResponse toFreeTalkResponse(FreeTalk freeTalk);
}
