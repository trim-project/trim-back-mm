package trim.api.domains.like.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import trim.common.annotation.UseCase;
import trim.domains.like.business.service.LikeDomainService;
import trim.domains.like.business.validator.LikeValidator;
import trim.domains.member.dao.domain.Member;

import static trim.common.util.StaticValues.*;

@UseCase
@Transactional
@RequiredArgsConstructor
public class ClickLikeAtTheBoardUseCase {

    private final LikeDomainService likeDomainService;
    private final LikeValidator likeValidator;

    public String execute(Long boardId, Member member) {
        if (likeValidator.isExist(boardId, member.getId())) {
            likeDomainService.removeLikeByBoardAndMember(boardId, member.getId());
            return LIKE_REMOVE_STATUS;
        }
        likeDomainService.createLike(boardId, member.getId());
        return LIKE_CREATE_STATUS;
    }
}
