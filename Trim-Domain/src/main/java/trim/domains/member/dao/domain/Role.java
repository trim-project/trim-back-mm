package trim.domains.member.dao.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.common.interfaces.KeyedEnum;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Role implements KeyedEnum {

    GUEST("ROLE_GUEST"), USER("ROLE_USER"), DORMANT("ROLE_DORMANT"), ADMIN("ROLE_ADMIN");

    private final String key;

}