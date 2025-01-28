package trim.api.domains.member.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.member.service.GetAllMemberUseCase;
import trim.api.domains.member.service.RegisterMemberUseCase;
import trim.api.domains.member.vo.MemberRequest;
import trim.api.domains.member.vo.MemberResponse;

import java.util.List;

@Tag(name = "[회원]")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/members")
public class MemberApiController {

    private final RegisterMemberUseCase registerMemberUseCase;
    private final GetAllMemberUseCase getAllMemberUseCase;

    @Operation(summary = "서버내 회원등록 테스트용 메서드입니다.")
    @PostMapping
    public ApiResponseDto<Long> registerServerTestMember(@RequestBody MemberRequest memberRequest) {
        return ApiResponseDto.onSuccess(registerMemberUseCase.execute(memberRequest));
    }

    @Operation(summary = "서버내 회원을 모두 조회합니다. 개발자를 위한 테스트용 메서드입니다.")
    @GetMapping
    public ApiResponseDto<List<MemberResponse>> getAllMemberResponseForTest() {
        return ApiResponseDto.onSuccess(getAllMemberUseCase.execute());
    }
}
