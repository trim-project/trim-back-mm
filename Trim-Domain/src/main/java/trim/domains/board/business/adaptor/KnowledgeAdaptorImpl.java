package trim.domains.board.business.adaptor;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.board.dao.domain.Knowledge;
import trim.domains.board.dao.repository.KnowledgeRepository;
import trim.domains.board.exception.BoardHandler;
import trim.domains.member.dao.domain.Member;

import java.util.List;

@Adaptor
@RequiredArgsConstructor
public class KnowledgeAdaptorImpl implements KnowledgeAdaptor{

    private final KnowledgeRepository knowledgeRepository;

    @Override
    public Knowledge queryKnowledgeById(Long knowledgeId) {
        return knowledgeRepository.findById(knowledgeId)
                .orElseThrow(() -> BoardHandler.KNOWLEDGE_NOT_FOUND);
    }

    @Override
    public Knowledge queryKnowledgeByUuid(String knowledgeUuid) {
        return knowledgeRepository.findByKnowledgeUuid(knowledgeUuid)
                .orElseThrow(() -> BoardHandler.KNOWLEDGE_NOT_FOUND);
    }

    @Override
    public List<Knowledge> queryKnowledgeByWriter(Member member) {
        return knowledgeRepository.findByWriter(member);
    }

    @Override
    public List<Knowledge> queryAllKnowledge() {
        return knowledgeRepository.findAll();
    }
}
