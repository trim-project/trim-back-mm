package trim.domains.member.dao.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST"), USER("ROLE_USER"), DORMANT("ROLE_DORMANT"), ADMIN("ROLE_ADMIN");

    private final String key;

    public static Role converter(String key) {
        return Arrays.stream(Role.values())
                .filter(role -> role.getKey().equals(key))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("not match any role"));
    }

}