package trim.api.domains.answer.service;

import lombok.RequiredArgsConstructor;
import trim.api.domains.answer.vo.AnswerRequest;
import trim.common.annotation.UseCase;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;

@UseCase
@RequiredArgsConstructor
public class WriteAnswerUseCase {

    private final AnswerDomainService answerDomainService;
    private final MemberAdaptor memberAdaptor;

    public Long execute(Long questionId, Long memberId, AnswerRequest request) {
        Member member = memberAdaptor.queryMember(memberId);
        return answerDomainService.writeAnswer(request, member, questionId).getId();
    }
}
