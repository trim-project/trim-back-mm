package trim.api.domains.knowledge.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import trim.api.common.util.EnumMappingUtil;
import trim.api.domains.knowledge.vo.request.KnowledgeRequest;
import trim.api.domains.knowledge.vo.response.KnowledgeResponse;
import trim.domains.board.dao.domain.Knowledge;
import trim.domains.board.dto.KnowledgeDto;

@Mapper(componentModel = "spring", uses = EnumMappingUtil.class, builder = @Builder(disableBuilder = false))
public interface KnowledgeMapper {

    KnowledgeMapper INSTANCE = Mappers.getMapper(KnowledgeMapper.class);

    @Mapping(target = "majorType", qualifiedByName = "stringToMajorType")
    KnowledgeDto toKnowledgeDto(KnowledgeRequest knowledgeRequest);

    @Mapping(target = "knowledgeId", source = "knowledge.id")
    @Mapping(target = "title", source = "knowledge.title")
    @Mapping(target = "content", source = "knowledge.content")
    @Mapping(target = "createdAt", source = "knowledge.createdAt", qualifiedByName = "localDateTimeToLong")
    KnowledgeResponse toKnowledgeResponse(Knowledge knowledge);
}
