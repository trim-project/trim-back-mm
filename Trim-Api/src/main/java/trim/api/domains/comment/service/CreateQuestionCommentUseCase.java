package trim.api.domains.comment.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.UseCase;
import trim.domains.board.business.adaptor.QuestionAdaptor;
import trim.domains.board.dao.domain.Question;
import trim.domains.comment.business.service.CommentDomainService;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;


@UseCase
@RequiredArgsConstructor
public class CreateQuestionCommentUseCase {

    private final QuestionAdaptor questionAdaptor;
    private final CommentDomainService questionCommentDomainService;
    private final MemberAdaptor memberAdaptor;

    public Long execute(Long memberId, Long questionId, String content){
        return questionCommentDomainService.createQuestionComment(
                memberAdaptor.queryMember(memberId),
                questionAdaptor.queryById(questionId),
                content
        );
    }
}
