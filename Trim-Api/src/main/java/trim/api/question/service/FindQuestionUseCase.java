package trim.api.question.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.question.dto.response.QuestionResponse;
import trim.common.annotation.UseCase;
import trim.domains.comment.adaptor.QuestionCommentAdaptor;
import trim.domains.comment.domain.QuestionComment;
import trim.domains.question.adaptor.QuestionAdaptor;
import trim.domains.question.domain.Question;

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
