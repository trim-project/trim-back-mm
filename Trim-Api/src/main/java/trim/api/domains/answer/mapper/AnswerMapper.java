package trim.api.domains.answer.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import trim.api.domains.answer.vo.AnswerResponse;
import trim.domains.board.dao.domain.Answer;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = false))
public interface AnswerMapper {

    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    @Mapping(target = "questionId", source = "answer.questionId")
    AnswerResponse toAnswerResponse(Answer answer);
}
