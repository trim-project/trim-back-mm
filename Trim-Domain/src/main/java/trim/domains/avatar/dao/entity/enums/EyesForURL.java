package trim.domains.avatar.dao.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.common.interfaces.KeyedEnum;

@Getter
@RequiredArgsConstructor
public enum EyesForURL implements KeyedEnum {

    EYES_1("eyes_1_image"),
    EYES_2("eyes_2_image"),
    EYES_3("eyes_3_image"),
    EYES_4("eyes_4_image"),
    EYES_5("eyes_5_image"),
    EYES_6("eyes_6_image"),
    EYES_7("eyes_7_image"),
    EYES_8("eyes_8_image"),
    EYES_9("eyes_9_image"),
    EYES_10("eyes_10_image"),
    EYES_11("eyes_11_image"),
    EYES_12("eyes_12_image");

    private final String key;
}
