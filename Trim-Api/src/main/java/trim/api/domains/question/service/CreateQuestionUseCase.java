package trim.api.domains.question.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.question.vo.request.QuestionRequest;
import trim.common.annotation.UseCase;
import trim.domains.board.business.service.QuestionDomainService;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;


@UseCase
@RequiredArgsConstructor
public class CreateQuestionUseCase {

    private final MemberAdaptor memberAdaptor;
    private final QuestionDomainService questionDomainService;

    @Transactional
    public Long execute(Long memberId, QuestionRequest questionRequest) {
        Member writer = memberAdaptor.queryMember(memberId);
        return questionDomainService.writeQuestion(writer, questionRequest.from());
    }

}
