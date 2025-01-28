package trim.domains.board.business.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.board.dao.domain.FreeTalk;
import trim.domains.board.dao.repository.FreeTalkRepository;
import trim.domains.board.dto.FreeTalkDto;
import trim.domains.member.dao.domain.Member;

@Adaptor
@RequiredArgsConstructor
public class FreeTalkDomainServiceImpl implements FreeTalkDomainService {

    private final FreeTalkRepository freeTalkRepository;

    @Override
    public Long createFreeTalk(Member member, FreeTalkDto dto) {
        FreeTalk newFreeTalk = FreeTalk.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();
        return freeTalkRepository.save(newFreeTalk).getId();
    }

    @Override
    public Long editFreeTalk(FreeTalk freeTalk, FreeTalkDto dto) {
        freeTalk.edit(dto);
        return freeTalk.getId();
    }

    @Override
    public void deleteFreeTalk(Long freeTalkId) {
        //Todo delete logic
    }
}
