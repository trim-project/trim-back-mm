package trim.api.domains.answer.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.api.domains.answer.mapper.AnswerMapper;
import trim.api.domains.avatar.vo.response.stored.StoredAvatarResponse;
import trim.api.domains.member.mapper.MemberMapper;
import trim.api.domains.member.vo.request.MemberProfileRequest;
import trim.api.domains.member.vo.response.MemberProfileResponse;
import trim.api.domains.member.vo.response.MemberResponse;
import trim.domains.board.dao.domain.Answer;

@Getter
@Builder
@RequiredArgsConstructor
public class AnswerDetailResponse {
    private final AnswerResponse answerResponse;
    private final MemberResponse memberResponse;
    private final StoredAvatarResponse storedAvatarResponse;
    public static AnswerDetailResponse of(Answer answer) {
        return AnswerDetailResponse.builder()
                .memberResponse(MemberMapper.INSTANCE.toMemberResponse(answer.getWriter()))
                .answerResponse(AnswerMapper.INSTANCE.toAnswerResponse(answer))
                .storedAvatarResponse(StoredAvatarResponse.builder()
                        .backgroundColor(answer.getWriter().getAvatar().getBackgroundColor())
                        .clothForURL(answer.getWriter().getAvatar().getClothForURL())
                        .mouthForURL(answer.getWriter().getAvatar().getMouthForURL())
                        .eyesForURL(answer.getWriter().getAvatar().getEyesForURL())
                        .hairForURL(answer.getWriter().getAvatar().getHairForURL())
                        .build())
                .build();
    }
}
