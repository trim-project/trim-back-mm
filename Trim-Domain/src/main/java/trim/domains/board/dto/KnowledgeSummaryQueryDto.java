package trim.domains.board.dto;

import lombok.Builder;
import lombok.Getter;
import trim.domains.board.dao.domain.MajorType;
import trim.domains.member.dao.domain.Role;
import trim.domains.member.dao.domain.SocialType;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class KnowledgeSummaryQueryDto {
    private Long knowledgeId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private MajorType majorType;

    private Long writerId;
    private String email;
    private String nickname;
    private Role role;
    private SocialType socialType;

    private Long likeCount;
    private Long commentCount;

    @Builder.Default
    private List<String> tagList = List.of();
}