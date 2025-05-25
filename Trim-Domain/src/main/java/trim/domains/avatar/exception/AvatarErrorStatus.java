package trim.domains.avatar.exception;

import com.google.rpc.BadRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import trim.common.annotation.ExplainError;
import trim.common.exception.BaseErrorCode;
import trim.common.exception.Reason;

import java.lang.reflect.Field;
import java.util.Objects;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@AllArgsConstructor
public enum AvatarErrorStatus implements BaseErrorCode {

    //entity AVATAR (4500-4549)
    AVATAR_HAIR_NOT_FOUND(NOT_FOUND, 4500, "헤어 요소를 찾을 수 없습니다." ),
    AVATAR_MOUTH_NOT_FOUND(NOT_FOUND, 4501, "입 요소를 찾을 수 없습니다."),
    AVATAR_EYES_NOT_FOUND(NOT_FOUND, 4502, "눈 요소를 찾을 수 없습니다."),
    AVATAR_CLOTH_NOT_FOUND(NOT_FOUND, 4503, "옷 요소를 찾을 수 없습니다."),

    AVATAR_ALREADY_PURCHASED_HAIR(BAD_REQUEST, 4504, "이미 구매한 머리입니다."),
    AVATAR_ALREADY_PURCHASED_MOUTH(BAD_REQUEST, 4505, "이미 구매한 입입니다."),
    AVATAR_ALREADY_PURCHASED_EYES(BAD_REQUEST, 4506, "이미 구매한 눈입니다."),
    AVATAR_ALREADY_PURCHASED_CLOTH(BAD_REQUEST, 4507, "이미 구매한 옷입니다.");
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