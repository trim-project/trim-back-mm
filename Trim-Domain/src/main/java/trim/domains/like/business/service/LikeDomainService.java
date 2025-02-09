package trim.domains.like.business.service;

import trim.domains.like.dao.entity.Like;

public interface LikeDomainService {

    Like createLike(Long boardId, Long memberId);

    void removeLike(Long likeId);

    void removeAllLikeByBoard(Long boardId);
}
