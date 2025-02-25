package trim.api.common.init;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.member.service.CreateMemberDummyDataUseCase;

@Tag(name = "[더미 데이터 입력]")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dummy")
public class DataInitializeApiController {

    private final CreateMemberDummyDataUseCase createMemberDummyDataUseCase;

    @Operation(summary = "member 더미 데이터를 입력합니다. memberCount는 입력할 데이터 개수입니다.")
    @PostMapping("/members")
    public ApiResponseDto<Boolean> createMemberDummyData(@RequestParam int memberCount) {
        return ApiResponseDto.onSuccess(createMemberDummyDataUseCase.execute(memberCount));
    }
}
