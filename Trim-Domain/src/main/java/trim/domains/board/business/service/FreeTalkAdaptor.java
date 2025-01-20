package trim.domains.board.business.service;

import trim.domains.board.dao.domain.FreeTalk;
import trim.domains.board.dto.FreeTalkDto;
import trim.domains.member.dao.domain.Member;

public interface FreeTalkAdaptor {

    Long createFreeTalk(Member member, FreeTalkDto dto);

    Long editFreeTalk(FreeTalk freeTalk, FreeTalkDto dto);

    void deleteFreeTalk(Long freeTalkId);
}
