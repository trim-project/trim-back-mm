package trim.domains.member.exception.handler;

import trim.common.exception.BaseCode;
import trim.common.exception.GeneralException;
import trim.domains.member.exception.MemberErrorStatus;

public class MemberNotFoundException extends GeneralException {

    public static final GeneralException EXCEPTION = new MemberNotFoundException();

    public MemberNotFoundException() {
        super(MemberErrorStatus.MEMBER_NOT_FOUND);
    }
}
