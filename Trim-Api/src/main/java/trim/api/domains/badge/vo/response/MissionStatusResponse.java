package trim.api.domains.badge.vo.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.common.interfaces.KeyedEnum;

@Getter
@RequiredArgsConstructor
public enum MissionStatusResponse implements KeyedEnum {

    SUCCESS("SUCCESS"),
    IN_PROGRESS("IN_PROGRESS"),
    LOCKED("LOCKED");

    private final String key;
}
