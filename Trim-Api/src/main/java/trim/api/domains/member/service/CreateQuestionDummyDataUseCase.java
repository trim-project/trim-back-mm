package trim.api.domains.member.service;

import lombok.RequiredArgsConstructor;
import trim.api.domains.question.service.WriteQuestionUseCase;
import trim.api.domains.question.vo.request.QuestionRequest;
import trim.common.annotation.UseCase;
import trim.domains.board.dao.domain.MajorType;
import trim.domains.member.business.adaptor.MemberAdaptor;
import trim.domains.member.dao.domain.Member;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class CreateQuestionDummyDataUseCase {

    private final MemberAdaptor memberAdaptor;
    private final WriteQuestionUseCase writeQuestionUseCase;

    public Boolean execute(Long memberId, int questionCount) {
        Member member = memberAdaptor.queryMember(memberId);
        for (int i = 0; i < questionCount; i++) {
            QuestionRequest request = QuestionRequest.builder()
                    .content("content Question" + i +"by" + memberId)
                    .majorType(MajorType.getRandomMajor().getKey())
                    .title("title Question" + i +"by" + memberId)
                    .tags(List.of("dummy1", "dummy2", "dummy3"))
                    .build();
            writeQuestionUseCase.execute(member.getProfile().getUsername(), request);
        }
        return true;
    }
}
