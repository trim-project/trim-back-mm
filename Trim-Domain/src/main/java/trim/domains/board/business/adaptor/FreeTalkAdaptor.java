package trim.domains.board.business.adaptor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import trim.domains.board.dao.domain.FreeTalk;
import trim.domains.member.dao.domain.Member;

import java.util.List;

public interface FreeTalkAdaptor {

    FreeTalk queryFreeTalkById(Long freeTalkId);

    List<FreeTalk> queryFreeTalksByWriter(Member member);

    List<FreeTalk> queryAllFreeTalk();

    Page<FreeTalk> queryAllFreeTalk(Pageable pageable);
}
