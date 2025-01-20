package trim.domains.board.dao.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.common.interfaces.KeyedEnum;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum ResolveStatus implements KeyedEnum {

    RESOLVED("RESOLVED"), UNRESOLVED("UNRESOLVED");

    private final String key;

}
