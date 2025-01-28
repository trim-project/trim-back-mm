package trim.api.domains.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.comment.mapper.CommentMapper;
import trim.api.domains.comment.vo.response.CommentDetailResponse;
import trim.api.domains.comment.vo.response.CommentResponse;
import trim.api.domains.member.mapper.MemberMapper;
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

    public List<CommentDetailResponse> execute(Long boardId) {
        List<Comment> comments = commentAdaptor.queryAllByBoardId(boardId);

        return comments.stream()
                .map(this::mapToCommentDetailResponse)
                .toList();
    }

    private CommentDetailResponse mapToCommentDetailResponse(Comment comment) {
        return CommentDetailResponse.builder()
                .memberResponse(MemberMapper.INSTANCE.toMemberResponse(comment.getWriter()))
                .commentResponse(CommentMapper.INSTANCE.toResponse(comment))
                .build();
    }
}
