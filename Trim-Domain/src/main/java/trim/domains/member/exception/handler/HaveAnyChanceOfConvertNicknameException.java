package trim.domains.member.exception.handler;

import trim.common.exception.GeneralException;
import trim.domains.member.exception.MemberErrorStatus;

public class HaveAnyChanceOfConvertNicknameException extends GeneralException {

    public static final GeneralException EXCEPTION = new HaveAnyChanceOfConvertNicknameException();

    public HaveAnyChanceOfConvertNicknameException() {
        super(MemberErrorStatus.MEMBER_HAVE_ANY_CHANCE_OF_CONVERT_NICKNAME);
    }
}
