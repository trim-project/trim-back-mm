package trim.domains.board.dao.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.common.interfaces.KeyedEnum;

import java.util.Random;

@Getter
@RequiredArgsConstructor
public enum MajorType implements KeyedEnum {
    ENGINEERING("engineering"),
    EDUCATION("education"),
    SOCIAL_SCIENCES("social-sciences"),
    ARTS_PHYSICAL_EDUCATION("arts-physical-education"),
    MEDICINE_PHARMACY("medicine-pharmacy"),
    HUMANITIES("humanities"),
    NATURAL_SCIENCES("natural-sciences"),
    ETC("etc");


    private final String key;

    private static final Random RANDOM = new Random();
    private static final MajorType[] VALUES = values();

    public static MajorType getRandomMajor() {
        return VALUES[RANDOM.nextInt(VALUES.length)];
    }
}
