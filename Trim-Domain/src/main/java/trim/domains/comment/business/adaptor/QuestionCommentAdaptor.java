package trim.domains.comment.business.adaptor;

import trim.domains.comment.dao.domain.QuestionComment;

import java.util.List;

public interface QuestionCommentAdaptor {

    QuestionComment queryById(Long questionCommentId);

    List<QuestionComment> queryAllByQuestionId(Long questionId);

}
