package trim.api.question.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import trim.api.question.model.request.CreateQuestionRequest;
import trim.domains.member.domain.Member;
import trim.domains.question.domain.Question;

public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    @Mapping(target = "writer", source = "writer")
    Question toEntity(Member writer, CreateQuestionRequest createQuestionRequest);

}
