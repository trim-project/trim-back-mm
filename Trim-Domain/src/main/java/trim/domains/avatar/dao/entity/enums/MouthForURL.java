package trim.domains.avatar.dao.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.common.interfaces.KeyedEnum;

@Getter
@RequiredArgsConstructor
public enum MouthForURL implements KeyedEnum {

    MOUTH_1("https://storage.googleapis.com/trim-cloud-bucket/Avatar_mouth_1.svg"),
    MOUTH_2("https://storage.googleapis.com/trim-cloud-bucket/Avatar_mouth_2.svg"),
    MOUTH_3("https://storage.googleapis.com/trim-cloud-bucket/Avatar_mouth_3.svg"),
    MOUTH_4("https://storage.googleapis.com/trim-cloud-bucket/Avatar_mouth_4.svg"),
    MOUTH_5("https://storage.googleapis.com/trim-cloud-bucket/Avatar_mouth_5.svg"),
    MOUTH_6("https://storage.googleapis.com/trim-cloud-bucket/Avatar_mouth_6.svg"),
    MOUTH_7("https://storage.googleapis.com/trim-cloud-bucket/Avatar_mouth_7.svg"),
    MOUTH_8("https://storage.googleapis.com/trim-cloud-bucket/Avatar_mouth_8.svg"),
    MOUTH_9("https://storage.googleapis.com/trim-cloud-bucket/Avatar_mouth_9.svg"),
    MOUTH_10("https://storage.googleapis.com/trim-cloud-bucket/Avatar_mouth_10.svg"),
    MOUTH_11("https://storage.googleapis.com/trim-cloud-bucket/Avatar_mouth_11.svg"),
    MOUTH_12("https://storage.googleapis.com/trim-cloud-bucket/Avatar_mouth_12.svg");

    private final String key;

}
