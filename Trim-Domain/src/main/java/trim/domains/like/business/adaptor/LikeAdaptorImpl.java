package trim.domains.like.business.adaptor;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.Adaptor;
import trim.domains.like.dao.repository.LikeRepository;

@Adaptor
@RequiredArgsConstructor
public class LikeAdaptorImpl implements LikeAdaptor{

    private final LikeRepository likeRepository;


    @Override
    public Long queryCountByBoard(Long boardId) {
        return likeRepository.countByBoardId(boardId);
    }

    @Override
    public boolean queryExist(Long boardId, Long memberId) {
        return likeRepository.existsByBoardIdAndMemberId(boardId, memberId);
    }
}
