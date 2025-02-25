package trim.api.domains.question.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.member.mapper.MemberMapper;
import trim.api.domains.question.mapper.QuestionMapper;
import trim.api.domains.question.vo.response.QuestionSummaryResponse;
import trim.common.annotation.UseCase;
import trim.domains.board.business.adaptor.AnswerAdaptor;
import trim.domains.board.business.adaptor.QuestionAdaptor;
import trim.domains.board.dao.domain.Question;
import trim.domains.like.business.adaptor.LikeAdaptor;
import trim.domains.tag.business.adaptor.TagAdaptor;

import java.util.List;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetHotQuestionsUseCase {

    private final QuestionAdaptor questionAdaptor;
    private final TagAdaptor tagAdaptor;
    private final LikeAdaptor likeAdaptor;
    private final AnswerAdaptor answerAdaptor;


    public List<QuestionSummaryResponse> execute(Pageable pageable) {
        Page<Question> questions = questionAdaptor.queryHotQuestions(pageable);
        return questions.getContent().stream()
                .map(this::mapToQuestionSummaryResponse)
                .toList();
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
