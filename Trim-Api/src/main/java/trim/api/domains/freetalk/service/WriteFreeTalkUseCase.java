package trim.api.domains.freetalk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.freetalk.vo.FreeTalkRequest;
import trim.common.annotation.UseCase;
import trim.domains.board.business.service.FreeTalkDomainService;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;

@UseCase
@Transactional
@RequiredArgsConstructor
public class WriteFreeTalkUseCase {

    private final FreeTalkDomainService freeTalkDomainService;
    private final MemberAdaptor memberAdaptor;

    public Long execute(FreeTalkRequest request, Long memberId) {
        Member member = memberAdaptor.queryMember(memberId);
        return freeTalkDomainService.createFreeTalk(member, request.from()).getId();
    }
}
