package trim.domains.avatar.dao.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.common.interfaces.KeyedEnum;

@Getter
@RequiredArgsConstructor
public enum MouthForURL implements KeyedEnum {

    MOUTH_1("mouth_1_image_url"),
    MOUTH_2("mouth_2_image_url"),
    MOUTH_3("mouth_3_image_url"),
    MOUTH_4("mouth_4_image_url"),
    MOUTH_5("mouth_5_image_url"),
    MOUTH_6("mouth_6_image_url"),
    MOUTH_7("mouth_7_image_url"),
    MOUTH_8("mouth_8_image_url"),
    MOUTH_9("mouth_9_image_url"),
    MOUTH_10("mouth_10_image_url"),
    MOUTH_11("mouth_11_image_url"),
    MOUTH_12("mouth_12_image_url");

    private final String key;

}
