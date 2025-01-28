package trim.api.domains.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.comment.mapper.CommentMapper;
import trim.api.domains.comment.vo.response.CommentResponse;
import trim.common.annotation.UseCase;
import trim.domains.comment.business.adaptor.CommentAdaptor;
import trim.domains.comment.dao.domain.Comment;

import java.util.List;
import java.util.stream.Collectors;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetCommentsOfBoardUseCase {

    private final CommentAdaptor commentAdaptor;

    public List<CommentResponse> execute(Long boardId) {
        List<Comment> comments = commentAdaptor.queryAllByBoardId(boardId);
        return comments.stream()
                .map(CommentMapper.INSTANCE::toResponse)
                .collect(Collectors.toList());
    }
}
