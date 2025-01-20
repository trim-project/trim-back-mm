package trim.api.domains.question.service;

import lombok.RequiredArgsConstructor;
import trim.api.domains.question.dto.response.QuestionResponse;
import trim.common.annotation.UseCase;
import trim.domains.board.business.adaptor.QuestionAdaptor;
import trim.domains.board.dao.domain.Question;
import trim.domains.comment.business.adaptor.CommentAdaptor;
import trim.domains.comment.dao.domain.Comment;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindQuestionUseCase {

    private final QuestionAdaptor questionAdaptor;
    private final CommentAdaptor commentAdaptor;

    public QuestionResponse execute(Long questionId) {
        Question question = questionAdaptor.queryById(questionId);
        List<Comment> comments = commentAdaptor.queryAllByBoardId(questionId);
        return QuestionResponse.of(question, comments);
    }
}
