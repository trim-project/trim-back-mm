package trim.api.domains.freetalk.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.freetalk.service.WriteFreeTalkUseCase;
import trim.api.domains.freetalk.vo.FreeTalkRequest;

@Tag(name = "[자유 게시판]")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/free-talks")
public class FreeTalkApiController {

    private final WriteFreeTalkUseCase writeFreeTalkUseCase;

    @PostMapping("/members/{memberId}")
    public ApiResponseDto<Long> writeFreeTalk(@PathVariable Long memberId,
                                              @RequestBody FreeTalkRequest request) {
        return ApiResponseDto.onSuccess(writeFreeTalkUseCase.execute(request, memberId));
    }
}
