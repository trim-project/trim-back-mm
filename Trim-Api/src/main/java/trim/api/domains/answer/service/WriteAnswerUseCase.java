package trim.api.domains.answer.service;

import lombok.RequiredArgsConstructor;
import trim.api.domains.answer.vo.AnswerRequest;
import trim.common.annotation.UseCase;
import trim.domains.board.business.service.AnswerDomainService;
import trim.domains.member.dao.domain.Member;

@UseCase
@RequiredArgsConstructor
public class WriteAnswerUseCase {

    private final AnswerDomainService answerDomainService;

    public Long execute(Long questionId, Member member, AnswerRequest request) {
        return answerDomainService.writeAnswer(request.from(), member, questionId).getId();
    }
}
