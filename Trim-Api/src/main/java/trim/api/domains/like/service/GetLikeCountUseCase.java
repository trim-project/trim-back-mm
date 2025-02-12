package trim.api.domains.like.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.like.business.adaptor.LikeAdaptor;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetLikeCountUseCase {

    private final LikeAdaptor likeAdaptor;

    public Long execute(Long boardId) {
        return likeAdaptor.queryCountByBoard(boardId);
    }
}
