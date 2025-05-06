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
    EMERALD_GREEN("emerald_green"),
    SKY_BLUE("sky_blue"),
    LAVENDER("lavender"),
    PURPLE("purple"),
    WHITE("white"),
    GRAY("gray"),
    BLACK("black");

    private final String key;

}
