package trim.domains.board.business.service;

import trim.domains.board.dao.domain.Knowledge;
import trim.domains.board.dto.KnowledgeDto;
import trim.domains.member.dao.domain.Member;

public interface KnowledgeDomainService {

    Knowledge createKnowledge(Member member, KnowledgeDto knowledgeDto);

    Knowledge editKnowledge(Knowledge knowledge, KnowledgeDto knowledgeDto);

}
