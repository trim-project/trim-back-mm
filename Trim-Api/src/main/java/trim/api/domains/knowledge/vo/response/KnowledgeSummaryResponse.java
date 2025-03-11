package trim.api.domains.knowledge.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.api.domains.knowledge.mapper.KnowledgeMapper;
import trim.api.domains.member.mapper.MemberMapper;
import trim.api.domains.member.vo.response.MemberResponse;
import trim.domains.board.dao.domain.Knowledge;
import trim.domains.member.dao.domain.Member;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class KnowledgeSummaryResponse {

    private final KnowledgeResponse knowledgeResponse;
    private final MemberResponse memberResponse;
    private final Long likeCount;
    private final Long commentCount;

    @Builder.Default
    private final List<String> tagList = new ArrayList<>();

    public static KnowledgeSummaryResponse of(Knowledge knowledge, Member member, Long likeCount, Long commentCount, List<String> tags) {
        return KnowledgeSummaryResponse.builder()
                .knowledgeResponse(KnowledgeMapper.INSTANCE.toKnowledgeResponse(knowledge))
                .memberResponse(MemberMapper.INSTANCE.toMemberResponse(member))
                .likeCount(likeCount)
                .commentCount(commentCount)
                .tagList(tags)
                .build();
    }
}
