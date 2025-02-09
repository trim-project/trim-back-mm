package trim.domains.like.exception;

import trim.common.exception.GeneralException;

public class LikeHandler extends GeneralException {
    public LikeHandler(LikeErrorStatus likeErrorStatus) {
        super(likeErrorStatus);
    }
}
