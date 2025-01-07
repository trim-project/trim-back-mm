package trim.domains.member.exception;

import trim.common.exception.BaseErrorCode;
import trim.common.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public static final GeneralException HAVE_ANY_CHANCE_OF_CONVERT_NICKNAME =
            new MemberHandler(MemberErrorStatus.MEMBER_HAVE_ANY_CHANCE_OF_CONVERT_NICKNAME);
    public static final GeneralException NOT_FOUND =
            new MemberHandler(MemberErrorStatus.MEMBER_NOT_FOUND);

    public MemberHandler(BaseErrorCode code) {
        super(code);
    }
}
