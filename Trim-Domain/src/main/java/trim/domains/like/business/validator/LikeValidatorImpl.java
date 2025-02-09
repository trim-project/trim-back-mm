package trim.domains.like.business.validator;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.DomainValidator;
import trim.domains.like.dao.repository.LikeRepository;

@DomainValidator
@RequiredArgsConstructor
public class LikeValidatorImpl implements LikeValidator{

    private final LikeRepository likeRepository;
    @Override
    public boolean isExist(Long boardId, Long memberId) {
        return likeRepository.existsByBoardIdAndMemberId(boardId, memberId);
    }
}
