package trim.domains.badge.dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.common.interfaces.KeyedEnum;

@Getter
@RequiredArgsConstructor
public enum BadgeContent implements KeyedEnum {
    WRITE_QUESTION("WRITE_QUESTION"),
    WRITE_ANSWER("WRITE_ANSWER"),
    WRITE_KNOWLEDGE("WRITE_KNOWLEDGE"),
    WRITE_FREE_TALK("WRITE_FREE_TALK"),
    WRITE_COMMENT("WRITE_COMMENT"),
    GET_LIKE("GET_LIKE"),
    GET_ADOPTED("GET_ADOPTED"),
    PARTICIPATE_SURVEY("PARTICIPATE_SURVEY");


    private final String key;
}
