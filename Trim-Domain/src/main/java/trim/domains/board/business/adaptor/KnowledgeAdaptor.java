package trim.domains.board.business.adaptor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import trim.domains.board.dao.domain.Knowledge;
import trim.domains.member.dao.domain.Member;

import java.util.List;

public interface KnowledgeAdaptor {

    Knowledge queryKnowledgeById(Long knowledgeId);

    List<Knowledge> queryKnowledgeByWriter(Member member);

    List<Knowledge> queryAllKnowledge();

    Page<Knowledge> queryAllKnowledge(Pageable pageable);

}
