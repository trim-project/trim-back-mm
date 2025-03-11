package trim.api.domains.knowledge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.knowledge.vo.request.KnowledgeRequest;
import trim.common.annotation.UseCase;
import trim.domains.board.dao.domain.MajorType;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;

import java.util.List;

@UseCase
@Transactional
@RequiredArgsConstructor
public class CreateKnowledgeDummyDataUseCase {

    private final MemberAdaptor memberAdaptor;
    private final WriteKnowledgeUseCase writeKnowledgeUseCase;

    public Boolean execute(Long memberId, int knowledgeCount) {
        Member member = memberAdaptor.queryMember(memberId);
        for (int i = 0; i < knowledgeCount; i++) {
            KnowledgeRequest request = KnowledgeRequest.builder()
                    .title("title of Knowledge" + i + "by" + memberId)
                    .content("content of Knowledge" + i + "by" + memberId)
                    .majorType(MajorType.getRandomMajor().getKey())
                    .tags(List.of("knowledge1", "knowledge2"))
                    .build();
            writeKnowledgeUseCase.execute(member, request);
        }
        return true;
    }
}
