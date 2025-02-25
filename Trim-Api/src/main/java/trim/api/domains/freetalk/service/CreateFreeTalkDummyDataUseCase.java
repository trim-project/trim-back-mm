package trim.api.domains.freetalk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.freetalk.vo.request.FreeTalkRequest;
import trim.common.annotation.UseCase;

@UseCase
@Transactional
@RequiredArgsConstructor
public class CreateFreeTalkDummyDataUseCase {

    private final WriteFreeTalkUseCase writeFreeTalkUseCase;

    public Boolean execute(Long memberId, int freeTalkCount) {
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
