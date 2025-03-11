package trim.api.domains.answer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.answer.vo.AnswerRequest;
import trim.common.annotation.UseCase;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;

@UseCase
@Transactional
@RequiredArgsConstructor
public class CreateAnswerDummyDataUseCase {

    private final MemberAdaptor memberAdaptor;
    private final WriteAnswerUseCase writeAnswerUseCase;

    public Boolean execute(Long questionId, Long memberId, int knowledgeCount) {
        Member member = memberAdaptor.queryMember(memberId);
        for (int i = 0; i < knowledgeCount; i++) {
            AnswerRequest request = AnswerRequest.builder()
                    .title("title of answer" + i + "by" + memberId)
                    .content("content of answer" + i + "by" + memberId)
                    .build();
            writeAnswerUseCase.execute(questionId, member, request);
        }
        return true;
    }
}
