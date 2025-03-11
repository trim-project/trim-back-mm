package trim.api.domains.answer.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.api.domains.answer.mapper.AnswerMapper;
import trim.api.domains.member.mapper.MemberMapper;
import trim.api.domains.member.vo.response.MemberResponse;
import trim.domains.board.dao.domain.Answer;

@Getter
@Builder
@RequiredArgsConstructor
public class AnswerDetailResponse {
    private final AnswerResponse answerResponse;
    private final MemberResponse memberResponse;

    public static AnswerDetailResponse of(Answer answer) {
        return AnswerDetailResponse.builder()
                .memberResponse(MemberMapper.INSTANCE.toMemberResponse(answer.getWriter()))
                .answerResponse(AnswerMapper.INSTANCE.toAnswerResponse(answer))
                .build();
    }
}
