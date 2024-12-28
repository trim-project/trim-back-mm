package trim.domains.comment.adaptor;

import trim.domains.comment.domain.QuestionComment;

import java.util.List;

public interface QuestionCommentAdaptor {
    List<QuestionComment> queryAllByQuestionId(Long questionId);

}
