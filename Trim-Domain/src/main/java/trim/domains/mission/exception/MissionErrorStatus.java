package trim.domains.mission.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import trim.common.annotation.ExplainError;
import trim.common.exception.BaseErrorCode;
import trim.common.exception.Reason;

import java.lang.reflect.Field;
import java.util.Objects;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum MissionErrorStatus implements BaseErrorCode {
    // entity MISSION (4400-4449)
    MISSION_NOT_FOUND(NOT_FOUND, 4400, "해당 미션을 찾을 수 없습니다."),
    MISSION_ALREADY_CLEAR(BAD_REQUEST, 4401, "미션을 이미 클리어하였습니다."),
    MISSION_NOT_CLEARED(BAD_REQUEST, 4402, "미션을 아직 클리어하지 못했습니다"),
    MISSION_WRONG_STATUS(BAD_REQUEST, 4403, "미션의 상태값이 예상값과 다릅니다"),
    MISSION_BADGE_SELECT_LEAST_AT_ZERO(INTERNAL_SERVER_ERROR, 4404, "배지 선택 개수는 음수가 될 수 없습니다."),
    MISSION_BADGE_MAXIMUM_SELECTED_BADGE_IS_THREE(BAD_REQUEST, 4405, "선택할 수 있는 배지 개수는 최대 세개입니다."),
    MISSION_BADGE_IS_NOT_SELECTED(BAD_REQUEST, 4406, "선택되지 않은 배지입니다.");

    private final HttpStatus httpStatus;
    private final Integer code;
    private final String message;

    @Override
    public Reason getReason() {
        return Reason.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public Reason getReasonHttpStatus() {
        return Reason.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }

    @Override
    public String getExplainError() throws NoSuchFieldException {
        Field field = this.getClass().getField(this.name());
        ExplainError annotation = field.getAnnotation(ExplainError.class);
        return Objects.nonNull(annotation) ? annotation.value() : this.getMessage();
    }
}
