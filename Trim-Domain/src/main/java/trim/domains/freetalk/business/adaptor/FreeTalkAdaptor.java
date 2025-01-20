package trim.domains.freetalk.business.adaptor;

import trim.domains.freetalk.dao.domain.FreeTalk;
import trim.domains.member.dao.domain.Member;

import java.util.List;

public interface FreeTalkAdaptor {

    FreeTalk queryFreeTalkById(Long freeTalkId);

    List<FreeTalk> queryFreeTalksByWriter(Member member);

    List<FreeTalk> queryAllFreeTalk();
}
