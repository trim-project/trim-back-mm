package trim.api.domains.comment.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.api.domains.avatar.vo.response.stored.StoredAvatarResponse;
import trim.api.domains.comment.mapper.CommentMapper;
import trim.api.domains.member.mapper.MemberMapper;
import trim.api.domains.member.vo.response.MemberResponse;
import trim.domains.comment.dao.domain.Comment;

@Getter
@Builder
@RequiredArgsConstructor
public class CommentDetailResponse {
    private final CommentResponse commentResponse;
    private final MemberResponse memberResponse;
    private final StoredAvatarResponse storedAvatarResponse;

    public static CommentDetailResponse of(Comment comment) {
        return CommentDetailResponse.builder()
                .commentResponse(CommentMapper.INSTANCE.toResponse(comment))
                .memberResponse(MemberMapper.INSTANCE.toMemberResponse(comment.getWriter()))
                .storedAvatarResponse(StoredAvatarResponse.builder()
                        .backgroundColor(comment.getWriter().getAvatar().getBackgroundColor())
                        .clothForURL(comment.getWriter().getAvatar().getClothForURL())
                        .mouthForURL(comment.getWriter().getAvatar().getMouthForURL())
                        .eyesForURL(comment.getWriter().getAvatar().getEyesForURL())
                        .hairForURL(comment.getWriter().getAvatar().getHairForURL())
                        .build())
                .build();
    }

}
