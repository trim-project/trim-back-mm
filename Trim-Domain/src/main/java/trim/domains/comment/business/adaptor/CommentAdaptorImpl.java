package trim.domains.comment.business.adaptor;


import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.comment.dao.domain.Comment;
import trim.domains.comment.dao.repository.CommentRepository;
import trim.domains.comment.exception.CommentHandler;

import java.util.List;

@Adaptor
@RequiredArgsConstructor
public class CommentAdaptorImpl implements CommentAdaptor{

    private final CommentRepository commentRepository;

    @Override
    public Comment queryById(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> CommentHandler.NOT_FOUND);
    }

    @Override
    public List<Comment> queryAllByBoardId(Long boardId) {
        return commentRepository.findByBoardId(boardId);
    }

    @Override
    public Long queryCountByBoardId(Long boardId) {
        return commentRepository.countByBoardId(boardId);
    }

}
