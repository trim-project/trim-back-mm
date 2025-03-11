package trim.api.domains.question.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.api.domains.member.mapper.MemberMapper;
import trim.api.domains.member.vo.response.MemberResponse;
import trim.api.domains.question.mapper.QuestionMapper;
import trim.domains.board.dao.domain.Question;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class QuestionSummaryResponse {

    private final QuestionResponse questionResponse;
    private final MemberResponse memberResponse;
    private final Long likeCount;
    private final Long answerCount;
    @Builder.Default
    private final List<String> tagList = new ArrayList<>();

    public static QuestionSummaryResponse of(Question question, Long answerCount, Long likeCount, List<String> tags) {
        return QuestionSummaryResponse.builder()
                .questionResponse(QuestionMapper.INSTANCE.toQuestionResponse(question))
                .memberResponse(MemberMapper.INSTANCE.toMemberResponse(question.getWriter()))
                .answerCount(answerCount)
                .likeCount(likeCount)
                .tagList(tags)
                .build();
    }
}
