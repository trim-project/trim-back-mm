package trim.api.domains.knowledge.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.api.domains.avatar.vo.response.stored.StoredAvatarResponse;
import trim.api.domains.comment.vo.response.CommentDetailResponse;
import trim.api.domains.knowledge.mapper.KnowledgeMapper;
import trim.api.domains.member.mapper.MemberMapper;
import trim.api.domains.member.vo.response.MemberResponse;
import trim.domains.board.dao.domain.Knowledge;
import trim.domains.comment.dao.domain.Comment;
import trim.domains.member.dao.domain.Member;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class KnowledgeDetailResponse {

    private final KnowledgeResponse knowledgeResponse;
    private final MemberResponse memberResponse;
    private final StoredAvatarResponse storedAvatarResponse;
    @Builder.Default
    private final List<CommentDetailResponse> commentResponses = new ArrayList<>();
    @Builder.Default
    private final List<String> tags = new ArrayList<>();

    public static KnowledgeDetailResponse of(Knowledge knowledge, Member member, List<Comment> comments, List<String> tags) {
        return KnowledgeDetailResponse.builder()
                .knowledgeResponse(KnowledgeMapper.INSTANCE.toKnowledgeResponse(knowledge))
                .memberResponse(MemberMapper.INSTANCE.toMemberResponse(member))
                .storedAvatarResponse(StoredAvatarResponse.builder()
                        .backgroundColor(knowledge.getWriter().getAvatar().getBackgroundColor())
                        .clothForURL(knowledge.getWriter().getAvatar().getClothForURL())
                        .mouthForURL(knowledge.getWriter().getAvatar().getMouthForURL())
                        .eyesForURL(knowledge.getWriter().getAvatar().getEyesForURL())
                        .hairForURL(knowledge.getWriter().getAvatar().getHairForURL())
                        .build())
                .commentResponses(comments.stream().map(CommentDetailResponse::of).toList())
                .tags(tags)
                .build();
    }
}
