package trim.domains.member.validate;

public interface MemberValidator {

    Boolean checkCanRegister(String username);

    Boolean checkCanConvertNickname(String nickname);
}
