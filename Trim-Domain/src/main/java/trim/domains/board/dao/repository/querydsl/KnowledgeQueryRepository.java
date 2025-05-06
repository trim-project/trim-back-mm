package trim.domains.board.dao.repository.querydsl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import trim.domains.board.dao.domain.Knowledge;
import trim.domains.board.dao.domain.MajorType;
import trim.domains.board.dto.KnowledgeSummaryQueryDto;

import java.util.List;

public interface KnowledgeQueryRepository {

    Page<Knowledge> searchKnowledge(MajorType majorType,
                                    List<String> keywordList,
                                    Pageable pageable);

    List<KnowledgeSummaryQueryDto> findAllKnowledgeSummaries();
}
