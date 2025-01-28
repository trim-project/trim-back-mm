package trim.api.domains.question.service;

import lombok.RequiredArgsConstructor;
import trim.api.domains.comment.mapper.CommentMapper;
import trim.api.domains.member.mapper.MemberMapper;
import trim.api.domains.question.mapper.QuestionMapper;
import trim.api.domains.question.vo.response.QuestionDetailResponse;
import trim.api.domains.question.vo.response.QuestionResponse;
import trim.common.annotation.UseCase;
import trim.domains.board.business.adaptor.QuestionAdaptor;
import trim.domains.board.dao.domain.Question;
import trim.domains.comment.business.adaptor.CommentAdaptor;
import trim.domains.comment.dao.domain.Comment;


import java.util.List;
import java.util.stream.Collectors;

@UseCase
@RequiredArgsConstructor
public class FindAllQuestionUseCase {
    private final QuestionAdaptor questionAdaptor;
    private final CommentAdaptor commentAdaptor;

    public List<QuestionDetailResponse> execute(){
        List<Question> questions = questionAdaptor.queryAll();
        return questions.stream()
                .map(question -> {
                    List<Comment> comments = commentAdaptor.queryAllByBoardId(question.getId());
                    return QuestionDetailResponse.builder()
                            .memberResponse(MemberMapper.INSTANCE.toMemberResponse(question.getWriter()))
                            .questionResponse(QuestionMapper.INSTANCE.toQuestionResponse(question))
                            .commentResponseList(comments.stream()
                                    .map(CommentMapper.INSTANCE::toResponse).collect(Collectors.toList()))
                            .build();
                }).collect(Collectors.toList());
    }

}
