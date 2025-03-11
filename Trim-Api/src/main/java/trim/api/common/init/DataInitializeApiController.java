package trim.api.common.init;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.answer.service.CreateAnswerDummyDataUseCase;
import trim.api.domains.freetalk.service.CreateFreeTalkDummyDataUseCase;
import trim.api.domains.knowledge.service.CreateKnowledgeDummyDataUseCase;
import trim.api.domains.member.service.CreateMemberDummyDataUseCase;
import trim.api.domains.member.service.CreateQuestionDummyDataUseCase;

@Tag(name = "[더미 데이터 입력]")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/access/dummy")
public class DataInitializeApiController {

    private final CreateMemberDummyDataUseCase createMemberDummyDataUseCase;
    private final CreateQuestionDummyDataUseCase createQuestionDummyDataUseCase;
    private final CreateFreeTalkDummyDataUseCase createFreeTalkDummyDataUseCase;
    private final CreateKnowledgeDummyDataUseCase createKnowledgeDummyDataUseCase;
    private final CreateAnswerDummyDataUseCase createAnswerDummyDataUseCase;

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

    @Operation(summary = "freeTalk 더미 데이터를 입력합니다. freeTalk count 는 입력할 데이터 개수입니다.")
    @PostMapping("/free-talks/members/{memberId}")
    public ApiResponseDto<Boolean> createFreeTalkDummyData(
            @PathVariable Long memberId,
            @RequestParam int freeTalkCount) {
        return ApiResponseDto.onSuccess(createFreeTalkDummyDataUseCase.execute(memberId, freeTalkCount));
    }

    @Operation(summary = "knowledge 더미 데이터를 입력합니다. knowledge count 는 입력할 데이터 개수입니다.")
    @PostMapping("/knowledge/members/{memberId}")
    public ApiResponseDto<Boolean> createKnowledgeDummyData(
            @PathVariable Long memberId,
            @RequestParam int knowledgeCount) {
        return ApiResponseDto.onSuccess(createKnowledgeDummyDataUseCase.execute(memberId, knowledgeCount));
    }

    @Operation(summary = "answer 더미 데이터를 입력합니다. answer count 는 입력할 데이터 개수입니다.")
    @PostMapping("/answers/questions/{questionId}/members/{memberId}")
    public ApiResponseDto<Boolean> createAnswerDummyData(
            @PathVariable Long questionId,
            @PathVariable Long memberId,
            @RequestParam int knowledgeCount) {
        return ApiResponseDto.onSuccess(createAnswerDummyDataUseCase.execute(questionId, memberId, knowledgeCount));
    }
}
