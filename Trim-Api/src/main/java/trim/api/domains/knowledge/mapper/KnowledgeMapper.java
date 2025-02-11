package trim.api.domains.knowledge.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import trim.api.common.util.EnumMappingUtil;
import trim.api.domains.knowledge.vo.request.KnowledgeRequest;
import trim.api.domains.question.vo.request.QuestionRequest;
import trim.common.util.EnumConvertUtil;
import trim.domains.board.dao.domain.MajorType;
import trim.domains.board.dto.KnowledgeDto;
import trim.domains.board.dto.QuestionDto;

@Mapper(componentModel = "spring", uses = EnumMappingUtil.class, builder= @Builder(disableBuilder = false))

public interface KnowledgeMapper {

    KnowledgeMapper INSTANCE = Mappers.getMapper(KnowledgeMapper.class);

    @Mapping(target = "majorType", qualifiedByName = "stringToMajorType")
    KnowledgeDto toKnowledgeDto(KnowledgeRequest knowledgeRequest);

}
