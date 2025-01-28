package trim.api.domains.question.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import trim.api.domains.question.vo.response.QuestionResponse;
import trim.domains.board.dao.domain.Question;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = false))
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    @Mapping(target = "title", source = "question.title")
    @Mapping(target = "content", source = "question.content")
    @Mapping(target = "createdAt", source = "question.createdAt")
    QuestionResponse toQuestionResponse(Question question);

}
