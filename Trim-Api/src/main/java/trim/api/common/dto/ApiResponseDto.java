package trim.api.common.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import trim.common.exception.BaseCode;
import trim.common.exception.SuccessStatus;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ApiResponseDto<T> {
    private final Boolean isSuccess;
    private final Integer code;
    private final String message;
    private T result;

    public static <T> ApiResponseDto<T> onSuccess(T result) {
        return new ApiResponseDto<>(true, 2000, SuccessStatus._SUCCESS.getMessage(), result);
    }

    public static <T> ApiResponseDto<T> of(BaseCode code, T result) {
        return new ApiResponseDto<>(true, code.getReasonHttpStatus().getCode(), code.getReasonHttpStatus().getMessage(), result);
    }

    public static <T> ApiResponseDto<T> onFailure(Integer code, String message, T data) {
        return new ApiResponseDto<>(false, code, message, data);
    }
}
