package trim.api.common.init;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.member.service.CreateMemberDummyDataUseCase;
import trim.api.domains.member.service.CreateQuestionDummyDataUseCase;

@Tag(name = "[더미 데이터 입력]")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dummy")
public class DataInitializeApiController {

    private final CreateMemberDummyDataUseCase createMemberDummyDataUseCase;
    private final CreateQuestionDummyDataUseCase createQuestionDummyDataUseCase;

    @Operation(summary = "member 더미 데이터를 입력합니다. member count 는 입력할 데이터 개수입니다.")
    @PostMapping("/members")
    public ApiResponseDto<Boolean> createMemberDummyData(@RequestParam int memberCount) {
        return ApiResponseDto.onSuccess(createMemberDummyDataUseCase.execute(memberCount));
    }

    @Operation(summary = "question 더미 데이터를 입력합니다. question count 는 입력할 데이터 개수입니다.")
    @PostMapping("/questions/members/{memberId}")
    public ApiResponseDto<Boolean> createQuestionDummyData(
            @PathVariable Long memberId,
            @RequestParam int questionCount) {
        return ApiResponseDto.onSuccess(createQuestionDummyDataUseCase.execute(memberId, questionCount));
    }
}
