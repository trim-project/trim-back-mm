package trim.api.domains.question.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.api.domains.avatar.vo.response.stored.StoredAvatarResponse;
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
    private final StoredAvatarResponse storedAvatarResponse;
    private final Long likeCount;
    private final Long answerCount;
    @Builder.Default
    private final List<String> tagList = new ArrayList<>();

    public static QuestionSummaryResponse of(Question question, Long answerCount, Long likeCount, List<String> tags) {
        return QuestionSummaryResponse.builder()
                .questionResponse(QuestionMapper.INSTANCE.toQuestionResponse(question))
                .memberResponse(MemberMapper.INSTANCE.toMemberResponse(question.getWriter()))
                .storedAvatarResponse(StoredAvatarResponse.builder()
                        .backgroundColor(question.getWriter().getAvatar().getBackgroundColor())
                        .clothForURL(question.getWriter().getAvatar().getClothForURL())
                        .mouthForURL(question.getWriter().getAvatar().getMouthForURL())
                        .eyesForURL(question.getWriter().getAvatar().getEyesForURL())
                        .hairForURL(question.getWriter().getAvatar().getHairForURL())
                        .build())
                .answerCount(answerCount)
                .likeCount(likeCount)
                .tagList(tags)
                .build();
    }
}
