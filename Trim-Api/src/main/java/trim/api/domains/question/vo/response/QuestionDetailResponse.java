package trim.api.domains.question.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.api.domains.answer.vo.AnswerDetailResponse;
import trim.api.domains.avatar.vo.response.stored.StoredAvatarResponse;
import trim.api.domains.member.mapper.MemberMapper;
import trim.api.domains.member.vo.response.MemberResponse;
import trim.api.domains.question.mapper.QuestionMapper;
import trim.domains.board.dao.domain.Answer;
import trim.domains.board.dao.domain.Question;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class QuestionDetailResponse {
    private final QuestionResponse questionResponse;
    private final MemberResponse memberResponse;
    private final StoredAvatarResponse storedAvatarResponse;
    @Builder.Default
    private final List<AnswerDetailResponse> answerDetailResponseList = new ArrayList<>();
    @Builder.Default
    private final List<String> tagList = new ArrayList<>();

    public static QuestionDetailResponse of(Question question, List<Answer> answers, List<String> tags) {
        return QuestionDetailResponse.builder()
                .questionResponse(QuestionMapper.INSTANCE.toQuestionResponse(question))
                .memberResponse(MemberMapper.INSTANCE.toMemberResponse(question.getWriter()))
                .storedAvatarResponse(StoredAvatarResponse.builder()
                        .backgroundColor(question.getWriter().getAvatar().getBackgroundColor())
                        .clothForURL(question.getWriter().getAvatar().getClothForURL())
                        .mouthForURL(question.getWriter().getAvatar().getMouthForURL())
                        .eyesForURL(question.getWriter().getAvatar().getEyesForURL())
                        .hairForURL(question.getWriter().getAvatar().getHairForURL())
                        .build())
                .answerDetailResponseList(answers.stream().map(AnswerDetailResponse::of).toList())
                .tagList(tags)
                .build();
    }

}
