package trim.api.domains.question.service;

import lombok.RequiredArgsConstructor;
import trim.api.domains.question.vo.response.QuestionDetailResponse;
import trim.common.annotation.UseCase;
import trim.domains.board.business.adaptor.AnswerAdaptor;
import trim.domains.board.business.adaptor.QuestionAdaptor;
import trim.domains.board.dao.domain.Answer;
import trim.domains.board.dao.domain.Question;
import trim.domains.tag.business.adaptor.TagAdaptor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetSpecificQuestionUseCase {

    private final QuestionAdaptor questionAdaptor;
    private final AnswerAdaptor answerAdaptor;
    private final TagAdaptor tagAdaptor;

    public QuestionDetailResponse execute(Long questionId) {
        Question question = questionAdaptor.queryById(questionId);
        List<Answer> answers = answerAdaptor.queryByQuestionId(questionId);
        List<String> tags = tagAdaptor.queryNamesByBoardId(questionId);

        return QuestionDetailResponse.of(question, answers, tags);
    }

}
