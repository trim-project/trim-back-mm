package trim.api.domains.freetalk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.api.domains.freetalk.vo.FreeTalkRequest;
import trim.common.annotation.UseCase;

@UseCase
@Transactional
@RequiredArgsConstructor
public class WriteFreeTalkUseCase {

    public Long execute(FreeTalkRequest request, Long memberId) {

    }
}
