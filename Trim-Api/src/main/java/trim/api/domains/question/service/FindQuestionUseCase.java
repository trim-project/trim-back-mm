package trim.api.domains.question.service;

import lombok.RequiredArgsConstructor;
import trim.api.domains.question.dto.response.QuestionResponse;
import trim.common.annotation.UseCase;
import trim.domains.comment.business.adaptor.QuestionCommentAdaptor;
import trim.domains.comment.dao.domain.QuestionComment;
import trim.domains.question.business.adaptor.QuestionAdaptor;
import trim.domains.question.dao.domain.Question;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindQuestionUseCase {

    private final QuestionAdaptor questionAdaptor;
    private final QuestionCommentAdaptor questionCommentAdaptor;

    public QuestionResponse execute(Long questionId) {
        Question question = questionAdaptor.queryById(questionId);
        List<QuestionComment> questionComments = questionCommentAdaptor.queryAllByQuestionId(questionId);
        return QuestionResponse.of(question, questionComments);
    }
}
