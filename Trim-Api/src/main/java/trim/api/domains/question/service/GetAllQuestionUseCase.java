package trim.api.domains.question.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.question.vo.response.QuestionDetailResponse;
import trim.common.annotation.UseCase;
import trim.domains.board.business.adaptor.AnswerAdaptor;
import trim.domains.board.business.adaptor.QuestionAdaptor;
import trim.domains.board.dao.domain.Answer;
import trim.domains.board.dao.domain.Question;
import trim.domains.tag.business.adaptor.TagAdaptor;


import java.util.List;
import java.util.stream.Collectors;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetAllQuestionUseCase {

    private final QuestionAdaptor questionAdaptor;
    private final AnswerAdaptor answerAdaptor;
    private final TagAdaptor tagAdaptor;

    public List<QuestionDetailResponse> execute() {
        List<Question> questions = questionAdaptor.queryAll();

        return questions.stream()
                .map(this::mapToQuestionDetailResponse)
                .collect(Collectors.toList());
    }

    private QuestionDetailResponse mapToQuestionDetailResponse(Question question) {
        List<Answer> answers = answerAdaptor.queryByQuestionId(question.getId());
        List<String> tags = tagAdaptor.queryNamesByBoardId(question.getId());

        return QuestionDetailResponse.of(question, answers, tags);
    }

}
