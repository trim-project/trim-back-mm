package trim.domains.avatar.dao.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.common.interfaces.KeyedEnum;

@Getter
@RequiredArgsConstructor
public enum EyesForURL implements KeyedEnum {

    EYES_1("https://storage.googleapis.com/trim-cloud-bucket/Avatar_eyes_1.svg"),
    EYES_2("https://storage.googleapis.com/trim-cloud-bucket/Avatar_eyes_2.svg"),
    EYES_3("https://storage.googleapis.com/trim-cloud-bucket/Avatar_eyes_3.svg"),
    EYES_4("https://storage.googleapis.com/trim-cloud-bucket/Avatar_eyes_4.svg"),
    EYES_5("https://storage.googleapis.com/trim-cloud-bucket/Avatar_eyes_5.svg"),
    EYES_6("https://storage.googleapis.com/trim-cloud-bucket/Avatar_eyes_6.svg"),
    EYES_7("https://storage.googleapis.com/trim-cloud-bucket/Avatar_eyes_7.svg"),
    EYES_8("https://storage.googleapis.com/trim-cloud-bucket/Avatar_eyes_8.svg"),
    EYES_9("https://storage.googleapis.com/trim-cloud-bucket/Avatar_eyes_9.svg"),
    EYES_10("https://storage.googleapis.com/trim-cloud-bucket/Avatar_eyes_10.svg"),
    EYES_11("https://storage.googleapis.com/trim-cloud-bucket/Avatar_eyes_11.svg"),
    EYES_12("https://storage.googleapis.com/trim-cloud-bucket/Avatar_eyes_12.svg");

    private final String key;
}
