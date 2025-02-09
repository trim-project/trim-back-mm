package trim.domains.like.business.service;

import trim.domains.like.dao.entity.Like;

public interface LikeDomainService {

    Like createLike(Long boardId, Long memberId);

    void removeLike(Long likeId);

    void removeLikeByBoardAndMember(Long boardId, Long memberId);

    void removeAllLikeByBoard(Long boardId);
}
