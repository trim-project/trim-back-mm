package trim.domains.avatar.dao.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.common.interfaces.KeyedEnum;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum MouthAvatarNumber implements KeyedEnum {
    MOUTH_1("mouth_1"),
    MOUTH_2("mouth_2"),
    MOUTH_3("mouth_3"),
    MOUTH_4("mouth_4"),
    MOUTH_5("mouth_5"),
    MOUTH_6("mouth_6"),
    MOUTH_7("mouth_7"),
    MOUTH_8("mouth_8"),
    MOUTH_9("mouth_9"),
    MOUTH_10("mouth_10"),
    MOUTH_11("mouth_11"),
    MOUTH_12("mouth_12");

    private final String key;

}
