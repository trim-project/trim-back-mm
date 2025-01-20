package trim.api.domains.comment.service;

import lombok.RequiredArgsConstructor;
import trim.api.domains.comment.vo.request.CreateQuestionCommentRequest;
import trim.common.annotation.UseCase;
import trim.domains.board.business.adaptor.QuestionAdaptor;
import trim.domains.board.dao.domain.Question;
import trim.domains.comment.business.service.CommentDomainService;
import trim.domains.member.dao.domain.Member;


@UseCase
@RequiredArgsConstructor
public class CreateQuestionCommentUseCase {

    private final QuestionAdaptor questionAdaptor;
    private final CommentDomainService questionCommentDomainService;

    public Long execute(Member writer, Long questionId, CreateQuestionCommentRequest dto){
        Question question = questionAdaptor.queryById(questionId);
        return questionCommentDomainService.createQuestionComment(writer, question, dto.getContent());
    }
}
