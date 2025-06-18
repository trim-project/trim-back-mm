package trim.api.domains.member.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.member.vo.request.MemberProfileRequest;
import trim.api.domains.member.vo.response.MemberProfileResponse;
import trim.api.domains.member.vo.response.MemberResponse;
import trim.common.annotation.AuthUser;
import trim.domains.member.dao.domain.Member;

@Tag(name = "[회원 🔑]")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/members")
public class MemberApiController {

    @Operation(summary = "멤버 프로필 정보를 조회합니다. 이름, 닉네임, 전공, 학교, 한줄 소개가 들어갑니다..")
    @GetMapping
    public ApiResponseDto<MemberProfileResponse> getMemberProfile(@Parameter(hidden = true) @AuthUser Member member) {
        return ApiResponseDto.onSuccess(null);
    }

    @Operation(summary = "멤버 프로필 정보를 수정합니다.")
    @PatchMapping
    public ApiResponseDto<Long> patchMemberProfile(@Parameter(hidden = true) @AuthUser Member member,
                                                   @RequestBody MemberProfileRequest memberProfileRequest) {
        return ApiResponseDto.onSuccess(null);
    }
}
