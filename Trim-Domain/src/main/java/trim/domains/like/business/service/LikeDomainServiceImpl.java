package trim.domains.like.business.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainService;
import trim.domains.like.dao.entity.Like;
import trim.domains.like.dao.repository.LikeRepository;

@DomainService
@RequiredArgsConstructor
public class LikeDomainServiceImpl implements LikeDomainService{

    private final LikeRepository likeRepository;

    @Override
    public Like createLike(Long boardId, Long memberId) {
        Like newLike = Like.builder()
                .boardId(boardId)
                .memberId(memberId)
                .build();
        return likeRepository.save(newLike);
    }

    @Override
    public void removeLike(Long likeId) {
        likeRepository.deleteById(likeId);
    }

    @Override
    public void removeLikeByBoardAndMember(Long boardId, Long memberId) {
        likeRepository.deleteByBoardIdAndMemberId(boardId, memberId);
    }

    @Override
    public void removeAllLikeByBoard(Long boardId) {
        likeRepository.deleteAllByBoardId(boardId);
    }
}
