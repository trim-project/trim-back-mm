package trim.domains.avatar.dao.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.common.interfaces.KeyedEnum;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum HairColor implements KeyedEnum {
    NAVY("navy"),
    RED_BROWN("red_brown"),
    DARK_BROWN("dark_brown"),
    LIGHT_BROWN("light_brown"),
    GOLD("gold"),
    PEACH("peach"),
    MINT("mint"),
    BLUE("blue"),
    LAVENDER("lavender"),
    PURPLE("purple"),
    BLONDE("blonde"),
    BLACK("black");

    private final String key;

    public static HairColor from(String key) {
        return Arrays.stream(values())
                .filter(color -> color.getKey().equalsIgnoreCase(key))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid HairColor key: " + key));
    }
}

