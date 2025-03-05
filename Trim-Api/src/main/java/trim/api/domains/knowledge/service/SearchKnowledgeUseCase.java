package trim.api.domains.knowledge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.knowledge.vo.response.KnowledgeListResponse;
import trim.api.domains.knowledge.vo.response.KnowledgeSummaryResponse;
import trim.common.annotation.UseCase;
import trim.common.util.EnumConvertUtil;
import trim.domains.board.business.adaptor.KnowledgeAdaptor;
import trim.domains.board.dao.domain.Knowledge;
import trim.domains.board.dao.domain.MajorType;
import trim.domains.comment.business.adaptor.CommentAdaptor;
import trim.domains.like.business.adaptor.LikeAdaptor;
import trim.domains.tag.business.adaptor.TagAdaptor;

import java.util.List;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SearchKnowledgeUseCase {

    private final KnowledgeAdaptor knowledgeAdaptor;
    private final LikeAdaptor likeAdaptor;
    private final CommentAdaptor commentAdaptor;
    private final TagAdaptor tagAdaptor;

    public KnowledgeListResponse execute(String majorType, List<String> keyword, Pageable pageable) {
        MajorType convertedMajorType = null;
        if (majorType != null) {
            convertedMajorType = EnumConvertUtil.convert(MajorType.class, majorType);
        }
        Page<Knowledge> knowledgePage = knowledgeAdaptor.queryKnowledgeBySearch(convertedMajorType, keyword, pageable);

        return KnowledgeListResponse.builder()
                .knowledgeResponseList(
                        knowledgePage.getContent().stream()
                                .map(knowledge ->
                                        KnowledgeSummaryResponse.of(
                                                knowledge,
                                                knowledge.getWriter(),
                                                likeAdaptor.queryCountByBoard(knowledge.getId()),
                                                commentAdaptor.queryCountByBoardId(knowledge.getId()),
                                                tagAdaptor.queryNamesByBoardId(knowledge.getId())))
                                .toList()
                )
                .page(knowledgePage.getNumber())
                .totalPages(knowledgePage.getTotalPages())
                .build();
    }
}
