package trim.domains.board.dao.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.common.interfaces.KeyedEnum;

@Getter
@RequiredArgsConstructor
public enum BoardType implements KeyedEnum {
    ANSWER("type_answer"),
    QUESTION("type_question"),
    FREE_TALK("type_free_talk");

    private final String key;
}
