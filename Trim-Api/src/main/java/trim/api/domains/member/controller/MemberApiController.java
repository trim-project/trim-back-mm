package trim.api.domains.member.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.member.service.RegisterMemberUseCase;
import trim.api.domains.member.vo.MemberRequest;

@Tag(name = "[회원]")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/members")
public class MemberApiController {

    private final RegisterMemberUseCase registerMemberUseCase;

    @Operation(summary = "서버내 회원등록 테스트용 메서드입니다.")
    @PostMapping
    public ApiResponseDto<Long> registerServerTestMember(@RequestBody MemberRequest memberRequest) {
        return ApiResponseDto.onSuccess(registerMemberUseCase.execute(memberRequest));
    }
}
