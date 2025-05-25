package trim.domains.member.exception;

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
public enum MemberErrorStatus implements BaseErrorCode {

    // entity MEMBER (4050-4099)
    MEMBER_NOT_FOUND(NOT_FOUND, 4050, "회원을 찾을 수 없습니다."),
    MEMBER_HAVE_ANY_CHANCE_OF_CONVERT_NICKNAME(BAD_REQUEST, 4051, "해당 회원은 사용할 수 있는 닉네임 변경 횟수를 모두 사용했습니다."),

    MEMBER_NOT_ENOUGH_POINT(BAD_REQUEST, 4052, "포인트가 부족합니다.");

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
