package trim.api.domains.freetalk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.comment.mapper.CommentMapper;
import trim.api.domains.comment.vo.response.CommentDetailResponse;
import trim.api.domains.freetalk.mapper.FreeTalkMapper;
import trim.api.domains.freetalk.vo.FreeTalkDetailResponse;
import trim.api.domains.member.mapper.MemberMapper;
import trim.common.annotation.UseCase;
import trim.domains.board.business.adaptor.FreeTalkAdaptor;
import trim.domains.board.dao.domain.FreeTalk;
import trim.domains.board.dao.domain.Question;
import trim.domains.comment.business.adaptor.CommentAdaptor;
import trim.domains.comment.dao.domain.Comment;

import java.util.List;
import java.util.stream.Collectors;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetAllFreeTalkUseCase {

    private final FreeTalkAdaptor freeTalkAdaptor;
    private final CommentAdaptor commentAdaptor;

    public List<FreeTalkDetailResponse> execute() {
        List<FreeTalk> freeTalks = freeTalkAdaptor.queryAllFreeTalk();

        return freeTalks.stream()
                .map(this::mapToFreeTalkDetailResponse)
                .collect(Collectors.toList());
    }

    private FreeTalkDetailResponse mapToFreeTalkDetailResponse(FreeTalk freeTalk) {
        List<Comment> comments = commentAdaptor.queryAllByBoardId(freeTalk.getId());
        return FreeTalkDetailResponse.builder()
                .freeTalkResponse(FreeTalkMapper.INSTANCE.toFreeTalkResponse(freeTalk))
                .memberResponse(MemberMapper.INSTANCE.toMemberResponse(freeTalk.getWriter()))
                .commentDetailResponseList(mapToCommentDetailResponseList(comments))
                .build();
    }

    private List<CommentDetailResponse> mapToCommentDetailResponseList(List<Comment> comments) {
        return comments.stream()
                .map(this::mapToCommentDetailResponse)
                .toList();
    }

    private CommentDetailResponse mapToCommentDetailResponse(Comment comment) {
        return CommentDetailResponse.builder()
                .commentResponse(CommentMapper.INSTANCE.toResponse(comment))
                .memberResponse(MemberMapper.INSTANCE.toMemberResponse(comment.getWriter()))
                .build();
    }
}
