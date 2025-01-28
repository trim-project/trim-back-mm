package trim.domains.board.exception;

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
public enum BoardErrorStatus implements BaseErrorCode {
    //entity BOARD
    BOARD_COULD_BE_TOUCHED_BY_ONLY_WRITER(BAD_REQUEST, 4000, "작성글은 오로지 작성자에 의해 수정&삭제가 가능합니다."),
    BOARD_TYPE_IS_NOT_MATCH(BAD_REQUEST, 4001, "작성글의 타입이 맞지 않습니다"),

    // entity QUESTION (4100-4149)
    QUESTION_NOT_FOUND(NOT_FOUND, 4100, "질문 글을 찾을 수 없습니다."),
    QUESTION_HAVE_ANY_ANSWER(BAD_REQUEST, 4101, "해당 질문글은 답변글을 가지지 않습니다."),
    QUESTION_COULD_BE_TOUCHED_BY_ONLY_WRITER(BAD_REQUEST, 4102, "질문글은 오로지 작성자에 의해 수정&삭제가 가능합니다."),

    // entity FreeTalk (4200-4249)
    FREE_TALK_NOT_FOUND(NOT_FOUND, 4200, "자유게시판을 찾을 수 없습니다."),
    FREE_TALK_COULD_BE_TOUCHED_BY_ONLY_WRITER(BAD_REQUEST, 4201, "자유게시판은 오로지 작성자에 의해 수정&삭제가 가능합니다."),

    // entity ANSWER (4250-4299)
    ANSWER_NOT_FOUND(NOT_FOUND, 4250, "답글을 찾을 수 없습니다."),
    ANSWER_COULD_BE_TOUCHED_BY_ONLY_WRITER(BAD_REQUEST, 4250, "답글은 오로지 작성자에 의해 수정&삭제가 가능합니다.");

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
