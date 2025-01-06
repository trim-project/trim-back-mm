package trim.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import trim.common.annotation.ExplainError;

import java.lang.reflect.Field;
import java.util.Objects;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode{

    // 서버 오류
    @ExplainError("500번대 알수없는 오류입니다. 서버 관리자에게 문의 주세요")
    _INTERNAL_SERVER_ERROR(INTERNAL_SERVER_ERROR, 5000, "서버 에러, 관리자에게 문의 바랍니다."),
    @ExplainError("인증이 필요없는 api입니다.")
    _UNAUTHORIZED_LOGIN_DATA_RETRIEVAL_ERROR(INTERNAL_SERVER_ERROR, 5001, "서버 에러, 로그인이 필요없는 요청입니다."),
    _ASSIGNABLE_PARAMETER(BAD_REQUEST, 5002, "인증타입이 잘못되어 할당이 불가능합니다."),

    // 일반적인 요청 오류
    _BAD_REQUEST(BAD_REQUEST, 4000, "잘못된 요청입니다."),
    _UNAUTHORIZED(UNAUTHORIZED, 4001, "로그인이 필요합니다."),
    _FORBIDDEN(FORBIDDEN, 4002, "금지된 요청입니다."),

    // entity MEMBER (4050-4099)
    MEMBER_NOT_FOUND(NOT_FOUND, 4050, "회원을 찾을 수 없습니다."),
    MEMBER_HAVE_ANY_CHANCE_OF_CONVERT_NICKNAME(BAD_REQUEST, 4051, "해당 회원은 사용할 수 있는 닉네임 변경 횟수를 모두 사용했습니다."),

    // entity QUESTION (4100-4149)
    QUESTION_NOT_FOUND(NOT_FOUND, 4100, "질문 글을 찾을 수 없습니다."),
    QUESTION_HAVE_ANY_ANSWER(BAD_REQUEST, 4101, "해당 질문글은 답변글을 가지지 않습니다."),
    QUESTION_COULD_BE_TOUCHED_BY_ONLY_WRITER(BAD_REQUEST, 4102, "질문글은 오로지 작성자에 의해 수정&삭제가 가능합니다."),

    // entity QUESTION_COMMENT (4150-4199)
    QUESTION_COMMENT_NOT_FOUND(NOT_FOUND, 4150, "질문게시글의 댓글을 찾을 수 없습니다."),
    QUESTION_COMMENT_COULD_BE_TOUCHED_BY_ONLY_WRITER(BAD_REQUEST, 4151, "질문의 댓글은 오로지 작성자에 의해 수정&삭제가 가능합니다.");

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
