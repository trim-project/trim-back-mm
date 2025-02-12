package trim.api.domains.knowledge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.knowledge.vo.response.KnowledgeDetailResponse;
import trim.common.annotation.UseCase;
import trim.domains.board.business.adaptor.KnowledgeAdaptor;
import trim.domains.board.dao.domain.Knowledge;
import trim.domains.comment.business.adaptor.CommentAdaptor;
import trim.domains.comment.dao.domain.Comment;
import trim.domains.tag.business.adaptor.TagAdaptor;

import java.util.List;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetSpecificKnowledgeUseCase {

    private final KnowledgeAdaptor knowledgeAdaptor;
    private final CommentAdaptor commentAdaptor;
    private final TagAdaptor tagAdaptor;

    public KnowledgeDetailResponse execute(String knowledgeUuid) {
        Knowledge knowledge = knowledgeAdaptor.queryKnowledgeByUuid(knowledgeUuid);
        List<Comment> comments = commentAdaptor.queryAllByBoardId(knowledge.getId());
        List<String> tags = tagAdaptor.queryNamesByBoardId(knowledge.getId());
        return KnowledgeDetailResponse.of(knowledge, knowledge.getWriter(), comments, tags);
    }
}
