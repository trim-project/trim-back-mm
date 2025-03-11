package trim.api.domains.freetalk.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.freetalk.service.*;
import trim.api.domains.freetalk.vo.request.FreeTalkRequest;
import trim.common.annotation.AuthUser;
import trim.domains.member.dao.domain.Member;

@Tag(name = "[자유 게시판🔑]")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/free-talks")
public class FreeTalkApiController {

    private final WriteFreeTalkUseCase writeFreeTalkUseCase;

    @Operation(summary = "자유 게시판 글을 작성합니다.")
    @PostMapping
    public ApiResponseDto<Long> writeFreeTalk(@Parameter(hidden = true) @AuthUser Member member,
                                              @RequestBody FreeTalkRequest request) {
        return ApiResponseDto.onSuccess(writeFreeTalkUseCase.execute(member, request));
    }


}
