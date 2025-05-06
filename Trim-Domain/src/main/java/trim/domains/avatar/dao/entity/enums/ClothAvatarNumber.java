package trim.domains.avatar.dao.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.common.interfaces.KeyedEnum;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum ClothAvatarNumber implements KeyedEnum {
    R1("r1"), R2("r2"), R3("r3"), R4("r4"),
    R5("r5"), R6("r6"), R7("r7"), R8("r8"),
    R9("r9"), R10("r10"), R11("r11"), R12("r12");

    private final String key;

    public static ClothAvatarNumber from(String key) {
        return Arrays.stream(values())
                .filter(value -> value.getKey().equalsIgnoreCase(key))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid ClothAvatarNumber key: " + key));
    }
}
