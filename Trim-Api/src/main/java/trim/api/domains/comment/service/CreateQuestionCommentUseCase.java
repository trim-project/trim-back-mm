package trim.api.domains.comment.service;

import lombok.RequiredArgsConstructor;
import trim.api.domains.comment.vo.request.CreateQuestionCommentRequest;
import trim.common.annotation.UseCase;
import trim.domains.comment.service.QuestionCommentDomainService;
import trim.domains.member.domain.Member;
import trim.domains.question.adaptor.QuestionAdaptor;
import trim.domains.question.domain.Question;

@UseCase
@RequiredArgsConstructor
public class CreateQuestionCommentUseCase {

    private final QuestionAdaptor questionAdaptor;
    private final QuestionCommentDomainService questionCommentDomainService;

    public Long execute(Member writer, Long questionId, CreateQuestionCommentRequest dto){
        Question question = questionAdaptor.queryById(questionId);
        return questionCommentDomainService.createQuestionComment(writer, question, dto.getContent());
    }
}
