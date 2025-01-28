package trim.api.domains.question.service;

import lombok.RequiredArgsConstructor;
import trim.api.domains.answer.mapper.AnswerMapper;
import trim.api.domains.answer.vo.AnswerDetailResponse;
import trim.api.domains.comment.mapper.CommentMapper;
import trim.api.domains.member.mapper.MemberMapper;
import trim.api.domains.member.vo.MemberResponse;
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
import trim.domains.member.dao.domain.Member;


import java.util.List;
import java.util.stream.Collectors;

@UseCase
@RequiredArgsConstructor
public class FindAllQuestionUseCase {

    private final QuestionAdaptor questionAdaptor;
    private final AnswerAdaptor answerAdaptor;

    public List<QuestionDetailResponse> execute() {
        List<Question> questions = questionAdaptor.queryAll();

        return questions.stream()
                .map(this::mapToQuestionDetailResponse)
                .collect(Collectors.toList());
    }

    private QuestionDetailResponse mapToQuestionDetailResponse(Question question) {
        List<Answer> answers = answerAdaptor.queryByQuestionId(question.getId());

        return QuestionDetailResponse.builder()
                .memberResponse(MemberMapper.INSTANCE.toMemberResponse(question.getWriter()))
                .questionResponse(QuestionMapper.INSTANCE.toQuestionResponse(question))
                .answerDetailResponseList(mapToAnswerDetailResponseList(answers))
                .build();
    }


    private List<AnswerDetailResponse> mapToAnswerDetailResponseList(List<Answer> answers) {
        return answers.stream()
                .map(this::mapToAnswerDetailResponse)
                .collect(Collectors.toList());
    }

    private AnswerDetailResponse mapToAnswerDetailResponse(Answer answer) {
        return AnswerDetailResponse.builder()
                .answerResponse(AnswerMapper.INSTANCE.toAnswerResponse(answer))
                .memberResponse(MemberMapper.INSTANCE.toMemberResponse(answer.getWriter()))
                .build();
    }


}
