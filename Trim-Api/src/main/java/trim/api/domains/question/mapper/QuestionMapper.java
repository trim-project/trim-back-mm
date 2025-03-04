package trim.api.domains.question.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import trim.api.common.util.EnumMappingUtil;
import trim.api.domains.question.vo.request.QuestionRequest;
import trim.api.domains.question.vo.response.QuestionResponse;
import trim.domains.board.dao.domain.Question;
import trim.domains.board.dto.QuestionDto;

@Mapper(componentModel = "spring", uses = EnumMappingUtil.class, builder = @Builder(disableBuilder = false))
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    @Mapping(target = "questionId", source = "question.id")
    @Mapping(target = "title", source = "question.title")
    @Mapping(target = "content", source = "question.content")
    @Mapping(target = "createdAt", source = "question.createdAt", qualifiedByName = "localDateTimeToLong")
    QuestionResponse toQuestionResponse(Question question);

    @Mapping(target = "majorType", qualifiedByName = "stringToMajorType")
    QuestionDto toQuestionDto(QuestionRequest questionRequest);

}
