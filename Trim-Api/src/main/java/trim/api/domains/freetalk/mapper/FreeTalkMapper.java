package trim.api.domains.freetalk.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import trim.api.domains.freetalk.vo.FreeTalkResponse;
import trim.api.domains.question.vo.response.QuestionResponse;
import trim.domains.board.dao.domain.FreeTalk;
import trim.domains.board.dao.domain.Question;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = false))
public interface FreeTalkMapper {

    FreeTalkMapper INSTANCE = Mappers.getMapper(FreeTalkMapper.class);

    @Mapping(target = "freeTalkId", source = "freeTalk.id")
    @Mapping(target = "title", source = "freeTalk.title")
    @Mapping(target = "content", source = "freeTalk.content")
    @Mapping(target = "createdAt", source = "freeTalk.createdAt")
    FreeTalkResponse toFreeTalkResponse(FreeTalk freeTalk);
}
