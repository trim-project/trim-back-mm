package trim.api.domains.like.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.common.util.StaticValues;
import trim.domains.like.business.adaptor.LikeAdaptor;
import trim.domains.like.business.service.LikeDomainService;
import trim.domains.like.business.validator.LikeValidator;

import static trim.common.util.StaticValues.*;

@UseCase
@Transactional
@RequiredArgsConstructor
public class ClickLikeAtTheBoardUseCase {

    private final LikeDomainService likeDomainService;
    private final LikeValidator likeValidator;

    public String execute(Long boardId, Long memberId) {
        if (likeValidator.isExist(boardId, memberId)) {
            likeDomainService.removeLikeByBoardAndMember(boardId, memberId);
            return LIKE_REMOVE_STATUS;
        }
        likeDomainService.createLike(boardId, memberId);
        return LIKE_REMOVE_STATUS;
    }
}
