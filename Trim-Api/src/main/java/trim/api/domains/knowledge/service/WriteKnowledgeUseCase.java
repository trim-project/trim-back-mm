package trim.api.domains.knowledge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.knowledge.mapper.KnowledgeMapper;
import trim.api.domains.knowledge.vo.request.KnowledgeRequest;
import trim.common.annotation.UseCase;
import trim.domains.board.business.service.KnowledgeDomainService;
import trim.domains.board.dao.domain.Knowledge;
import trim.domains.member.dao.domain.Member;
import trim.domains.tag.business.service.TagDomainService;

@UseCase
@Transactional
@RequiredArgsConstructor
public class WriteKnowledgeUseCase {

    private final KnowledgeDomainService knowledgeDomainService;
    private final TagDomainService tagDomainService;

    public Long execute(Member member, KnowledgeRequest knowledgeRequest) {
        Knowledge knowledge = knowledgeDomainService
                .createKnowledge(member, KnowledgeMapper.INSTANCE.toKnowledgeDto(knowledgeRequest));
        tagDomainService.addTagsInBoard(knowledge.getId(), knowledgeRequest.getTags());
        return knowledge.getId();
    }
}
