package trim.api.domains.reply.vo;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import trim.api.domains.answer.vo.AnswerDetailResponse;
import trim.api.domains.member.mapper.MemberMapper;
import trim.api.domains.member.vo.response.MemberResponse;
import trim.api.domains.question.mapper.QuestionMapper;
import trim.api.domains.question.vo.response.QuestionDetailResponse;
import trim.api.domains.reply.mapper.ReplyMapper;
import trim.domains.board.dao.domain.Answer;
import trim.domains.board.dao.domain.Question;
import trim.domains.reply.dao.entity.Reply;

import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
public class ReplyDetailResponse {

    private final ReplyResponse replyResponse;
    private final MemberResponse memberResponse;

    public static ReplyDetailResponse of(Reply reply) {
        return ReplyDetailResponse.builder()
                .replyResponse(ReplyMapper.INSTANCE.toReplyResponse(reply))
                .memberResponse(MemberMapper.INSTANCE.toMemberResponse(reply.getMember()))
                .build();
    }
}
