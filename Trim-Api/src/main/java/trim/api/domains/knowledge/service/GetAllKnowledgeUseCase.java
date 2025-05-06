package trim.api.domains.knowledge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.knowledge.vo.response.KnowledgeSummaryResponse;
import trim.common.annotation.UseCase;
import trim.domains.board.business.adaptor.KnowledgeAdaptor;
import trim.domains.board.dao.domain.Knowledge;
import trim.domains.comment.business.adaptor.CommentAdaptor;
import trim.domains.like.business.adaptor.LikeAdaptor;
import trim.domains.tag.business.adaptor.TagAdaptor;

import java.util.List;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetAllKnowledgeUseCase {

    private final KnowledgeAdaptor knowledgeAdaptor;
    private final TagAdaptor tagAdaptor;
    private final LikeAdaptor likeAdaptor;
    private final CommentAdaptor commentAdaptor;

//    public List<KnowledgeSummaryResponse> execute() {
//        List<Knowledge> knowledgeList = knowledgeAdaptor.queryAllKnowledge();
//        return knowledgeList.stream()
//                .map(knowledge ->
//                        KnowledgeSummaryResponse.of(
//                                knowledge,
//                                knowledge.getWriter(),
//                                likeAdaptor.queryCountByBoard(knowledge.getId()),
//                                commentAdaptor.queryCountByBoardId(knowledge.getId()),
//                                tagAdaptor.queryNamesByBoardId(knowledge.getId())))
//                .toList();
//    }
    public List<KnowledgeSummaryResponse> execute() {
        return knowledgeAdaptor.queryAllKnowledgeSummaryDtoList().stream()
                .map(knowledgeDto -> KnowledgeSummaryResponse.of(knowledgeDto))
                .toList();
    }
}
