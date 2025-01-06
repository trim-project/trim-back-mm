package trim.api.domains.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.member.service.RegisterMemberUseCase;
import trim.api.domains.member.vo.MemberRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/members")
public class MemberApiController {

    private final RegisterMemberUseCase registerMemberUseCase;

    @PostMapping
    public ApiResponseDto<Long> registerServerTestMember(@RequestBody MemberRequest memberRequest) {
        return ApiResponseDto.onSuccess(registerMemberUseCase.execute(memberRequest));
    }
}
