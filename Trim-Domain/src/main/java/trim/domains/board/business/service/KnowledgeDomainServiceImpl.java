package trim.domains.board.business.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainService;
import trim.domains.board.dao.domain.BoardType;
import trim.domains.board.dao.domain.Knowledge;
import trim.domains.board.dao.repository.jpa.KnowledgeRepository;
import trim.domains.board.dto.KnowledgeDto;
import trim.domains.member.dao.domain.Member;

@DomainService
@RequiredArgsConstructor
public class KnowledgeDomainServiceImpl implements KnowledgeDomainService{

    private final KnowledgeRepository knowledgeRepository;

    @Override
    public Knowledge createKnowledge(Member member, KnowledgeDto knowledgeDto) {
        Knowledge newKnowledge = Knowledge.builder()
                .writer(member)
                .title(knowledgeDto.getTitle())
                .content(knowledgeDto.getContent())
                .majorType(knowledgeDto.getMajorType())
                .boardType(BoardType.KNOWLEDGE)
                .build();
        return knowledgeRepository.save(newKnowledge);
    }

    @Override
    public Knowledge editKnowledge(Knowledge knowledge, KnowledgeDto knowledgeDto) {
        knowledge.edit(knowledgeDto);
        return knowledge;
    }
}
