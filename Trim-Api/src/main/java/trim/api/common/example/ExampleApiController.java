package trim.api.common.example;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trim.common.annotation.ApiErrorStatusExample;
import trim.common.annotation.DisableSwaggerSecurity;
import trim.common.exception.ErrorStatus;
import trim.domains.member.exception.MemberErrorStatus;
import trim.domains.question.exception.QuestionErrorStatus;

@RestController
@RequestMapping("/v1/api/examples")
@RequiredArgsConstructor
@Tag(name = "xx. [예시] 에러코드 문서화")
public class ExampleApiController {

    @GetMapping("/health")
    @DisableSwaggerSecurity
    public void health() {}

    @GetMapping("/global")
    @Operation(summary = "글로벌 ( 인증 , aop, 서버 내부 오류등)  관련 에러 코드 나열")
    @ApiErrorStatusExample(ErrorStatus.class)
    public void getGlobalErrorCode() {}

    @GetMapping("/user")
    @Operation(summary = "유저 도메인 관련 에러 코드 나열")
    @ApiErrorStatusExample(MemberErrorStatus.class)
    public void getUserErrorCode() {}

    @GetMapping("/question")
    @Operation(summary = "질문게시글 도메인 관련 에러 코드 나열")
    @ApiErrorStatusExample(QuestionErrorStatus.class)
    public void getQuestionErrorCode() {}

    @GetMapping("/question/comment")
    @Operation(summary = "질문게시글 댓글 도메인 관련 에러 코드 나열")
    @ApiErrorStatusExample(QuestionErrorStatus.class)
    public void getQuestionCommentErrorCode() {}
}
