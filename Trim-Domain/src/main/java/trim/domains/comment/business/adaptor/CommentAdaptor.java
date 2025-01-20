package trim.domains.comment.business.adaptor;

import trim.domains.comment.dao.domain.Comment;


import java.util.List;

public interface CommentAdaptor {

    Comment queryById(Long commentId);

    List<Comment> queryAllByBoardId(Long boardId);

}
