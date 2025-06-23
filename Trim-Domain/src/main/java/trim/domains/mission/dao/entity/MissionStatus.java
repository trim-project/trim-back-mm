package trim.domains.mission.dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.common.interfaces.KeyedEnum;

@Getter
@RequiredArgsConstructor
public enum MissionStatus implements KeyedEnum {
    SUCCESS("SUCCESS"), IN_PROGRESS("IN_PROGRESS"), LOCKED("LOCKED"), GETTO("GETTO");
    private final String key;
}
