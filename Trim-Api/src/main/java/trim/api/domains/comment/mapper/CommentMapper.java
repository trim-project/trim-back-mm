package trim.api.domains.comment.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import trim.api.domains.comment.vo.response.CommentResponse;
import trim.domains.comment.dao.domain.Comment;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = false))
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentResponse toResponse(Comment comment);
}
