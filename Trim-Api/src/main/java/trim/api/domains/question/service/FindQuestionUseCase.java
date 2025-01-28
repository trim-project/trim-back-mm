package trim.api.domains.question.service;

import lombok.RequiredArgsConstructor;
import trim.api.domains.answer.mapper.AnswerMapper;
import trim.api.domains.answer.vo.AnswerDetailResponse;
import trim.api.domains.comment.mapper.CommentMapper;
import trim.api.domains.member.mapper.MemberMapper;
import trim.api.domains.question.mapper.QuestionMapper;
import trim.api.domains.question.vo.response.QuestionDetailResponse;
import trim.api.domains.question.vo.response.QuestionResponse;
import trim.common.annotation.UseCase;
import trim.domains.board.business.adaptor.AnswerAdaptor;
import trim.domains.board.business.adaptor.QuestionAdaptor;
import trim.domains.board.dao.domain.Answer;
import trim.domains.board.dao.domain.Question;
import trim.domains.comment.business.adaptor.CommentAdaptor;
import trim.domains.comment.dao.domain.Comment;
import trim.domains.tag.business.adaptor.TagAdaptor;

import java.util.List;
import java.util.stream.Collectors;

@UseCase
@RequiredArgsConstructor
public class FindQuestionUseCase {

    private final QuestionAdaptor questionAdaptor;
    private final AnswerAdaptor answerAdaptor;
    private final TagAdaptor tagAdaptor;

    public QuestionDetailResponse execute(Long questionId) {
        Question question = questionAdaptor.queryById(questionId);
        List<Answer> answers = answerAdaptor.queryByQuestionId(questionId);

        return QuestionDetailResponse.builder()
                .memberResponse(MemberMapper.INSTANCE.toMemberResponse(question.getWriter()))
                .questionResponse(QuestionMapper.INSTANCE.toQuestionResponse(question))
                .answerDetailResponseList(
                        answers.stream()
                                .map(answer -> AnswerDetailResponse.builder()
                                            .answerResponse(AnswerMapper.INSTANCE.toAnswerResponse(answer))
                                            .memberResponse(MemberMapper.INSTANCE.toMemberResponse(answer.getWriter()))
                                            .build()
                                )
                                .collect(Collectors.toList())
                )
                .tagList(tagAdaptor.queryNamesByBoardId(questionId))
                .build();
    }

}
