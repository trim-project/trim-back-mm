package trim.domains.avatar.dao.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.common.interfaces.KeyedEnum;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum ClothColor implements KeyedEnum {
    RED("red"),
    PINK("pink"),
    ORANGE("orange"),
    YELLOW("yellow"),
    YELLOW_GREEN("yellow_green"),
    AMERALD_GREEN("amerald_green"),
    SKY_BLUE("sky_blue"),
    LAVENDER("lavender"),
    PURPLE("purple"),
    WHITE("white"),
    GRAY("gray"),
    BLACK("black");

    private final String key;

    public static ClothColor from(String key) {
        return Arrays.stream(values())
                .filter(color -> color.getKey().equalsIgnoreCase(key))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid ClothColor key: " + key));
    }
}
