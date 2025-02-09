package trim.api.domains.question.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.member.mapper.MemberMapper;
import trim.api.domains.question.mapper.QuestionMapper;
import trim.api.domains.question.vo.response.QuestionDetailResponse;
import trim.api.domains.question.vo.response.QuestionSummaryResponse;
import trim.common.annotation.UseCase;
import trim.domains.board.business.adaptor.AnswerAdaptor;
import trim.domains.board.business.adaptor.QuestionAdaptor;
import trim.domains.board.dao.domain.Answer;
import trim.domains.board.dao.domain.Question;
import trim.domains.like.business.adaptor.LikeAdaptor;
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
    private final LikeAdaptor likeAdaptor;

    public List<QuestionSummaryResponse> execute() {
        List<Question> questions = questionAdaptor.queryAll();

        return questions.stream()
                .map(this::mapToQuestionSummaryResponse)
                .collect(Collectors.toList());
    }

    private QuestionSummaryResponse mapToQuestionSummaryResponse(Question question) {
        List<String> tags = tagAdaptor.queryNamesByBoardId(question.getId());

        return QuestionSummaryResponse.builder()
                .questionResponse(QuestionMapper.INSTANCE.toQuestionResponse(question))
                .memberResponse(MemberMapper.INSTANCE.toMemberResponse(question.getWriter()))
                .likeCount(likeAdaptor.queryCountByBoard(question.getId()))
                .answerCount(answerAdaptor.queryCountByQuestionId(question.getId()))
                .tagList(tags)
                .build();
    }

}
