package trim.domains.board.business.adaptor;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.board.dao.domain.FreeTalk;
import trim.domains.board.dao.repository.FreeTalkRepository;
import trim.domains.freetalk.exception.FreeTalkHandler;
import trim.domains.member.dao.domain.Member;

import java.util.List;

@Adaptor
@RequiredArgsConstructor
public class FreeTalkAdaptorImpl implements FreeTalkAdaptor{
    private final FreeTalkRepository freeTalkRepository;

    @Override
    public FreeTalk queryFreeTalkById(Long freeTalkId) {
        return freeTalkRepository.findById(freeTalkId).orElseThrow(() -> FreeTalkHandler.NOT_FOUND);
    }

    @Override
    public List<FreeTalk> queryFreeTalksByWriter(Member member) {
        return freeTalkRepository.findByWriter(member);
    }

    @Override
    public List<FreeTalk> queryAllFreeTalk() {
        return freeTalkRepository.findAll();
    }
}
