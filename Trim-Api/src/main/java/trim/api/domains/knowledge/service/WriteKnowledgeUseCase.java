package trim.api.domains.knowledge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.knowledge.mapper.KnowledgeMapper;
import trim.api.domains.knowledge.vo.request.KnowledgeRequest;
import trim.common.annotation.UseCase;
import trim.domains.board.business.service.KnowledgeDomainService;
import trim.domains.board.dao.domain.Knowledge;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;

@UseCase
@Transactional
@RequiredArgsConstructor
public class WriteKnowledgeUseCase {

    private final KnowledgeDomainService knowledgeDomainService;
    private final MemberAdaptor memberAdaptor;

    public Long execute(Long memberId, KnowledgeRequest knowledgeRequest) {
        Member member = memberAdaptor.queryMember(memberId);
        Knowledge knowledge = knowledgeDomainService
                .createKnowledge(member, KnowledgeMapper.INSTANCE.toKnowledgeDto(knowledgeRequest));
        return knowledge.getId();
    }
}
