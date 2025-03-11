package trim.api.domains.freetalk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.freetalk.vo.request.FreeTalkRequest;
import trim.common.annotation.UseCase;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;

@UseCase
@Transactional
@RequiredArgsConstructor
public class CreateFreeTalkDummyDataUseCase {

    private final WriteFreeTalkUseCase writeFreeTalkUseCase;
    private final MemberAdaptor memberAdaptor;

    public Boolean execute(Long memberId, int freeTalkCount) {
        Member member = memberAdaptor.queryMember(memberId);
        for (int i = 0; i < freeTalkCount; i++) {
            FreeTalkRequest request = FreeTalkRequest.builder()
                    .title("title of FreeTalk" + i + "by" + memberId)
                    .content("content of FreeTalk" + i + "by" + memberId)
                    .build();
            writeFreeTalkUseCase.execute(memberId, request);
        }
        return true;
    }
}
