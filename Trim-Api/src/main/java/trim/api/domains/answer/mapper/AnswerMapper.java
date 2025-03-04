package trim.api.domains.answer.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import trim.api.common.util.EnumMappingUtil;
import trim.api.domains.answer.vo.AnswerResponse;
import trim.domains.board.dao.domain.Answer;

@Mapper(componentModel = "spring", uses = EnumMappingUtil.class, builder = @Builder(disableBuilder = false))
public interface AnswerMapper {

    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    @Mapping(target = "questionId", source = "answer.questionId")
    @Mapping(target = "createdAt", source = "answer.createdAt", qualifiedByName = "localDateTimeToLong")
    AnswerResponse toAnswerResponse(Answer answer);
}
