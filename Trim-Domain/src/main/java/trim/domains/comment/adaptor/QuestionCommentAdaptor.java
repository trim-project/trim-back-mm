package trim.domains.comment.adaptor;

import trim.domains.comment.domain.QuestionComment;

import java.util.List;

public interface QuestionCommentAdaptor {

    QuestionComment queryById(Long questionCommentId);

    List<QuestionComment> queryAllByQuestionId(Long questionId);

}
