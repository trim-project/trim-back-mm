package trim.domains.avatar.dao.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.common.interfaces.KeyedEnum;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum EyesAvatarNumber implements KeyedEnum {
    EYES_1("eyes_1"),
    EYES_2("eyes_2"),
    EYES_3("eyes_3"),
    EYES_4("eyes_4"),
    EYES_5("eyes_5"),
    EYES_6("eyes_6"),
    EYES_7("eyes_7"),
    EYES_8("eyes_8"),
    EYES_9("eyes_9"),
    EYES_10("eyes_10"),
    EYES_11("eyes_11"),
    EYES_12("eyes_12");

    private final String key;

    public static EyesAvatarNumber from(String key) {
        return Arrays.stream(values())
                .filter(e -> e.getKey().equalsIgnoreCase(key))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid EyesAvatarNumber key: " + key));
    }
}
