package trim.api.domains.avatar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.member.dao.domain.Member;

@UseCase
@Transactional
@RequiredArgsConstructor
public class SetPointFreeUseCase {

    public Long execute(Member member, int point) {
        member.addPoint(point);
        return member.getId();
    }
}
