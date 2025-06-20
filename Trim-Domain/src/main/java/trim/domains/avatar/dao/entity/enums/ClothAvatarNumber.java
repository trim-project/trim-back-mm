package trim.domains.avatar.dao.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.common.interfaces.KeyedEnum;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum ClothAvatarNumber implements KeyedEnum {
    R1("r1"), R2("r2"), R3("r3"), R4("r4"),
    R5("r5"), R7("r7"), R9("r9"), R10("r10"),
    R11("r11"), R12("r12");

    private final String key;

}
