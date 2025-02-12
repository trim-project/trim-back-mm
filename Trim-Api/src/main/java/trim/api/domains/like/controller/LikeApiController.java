package trim.api.domains.like.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.like.service.ClickLikeAtTheBoardUseCase;
import trim.api.domains.like.service.GetLikeCountUseCase;

@Tag(name = "[좋아요]")
@RestController
@RequestMapping("/api/likes")
@RequiredArgsConstructor
public class LikeApiController {

    private final ClickLikeAtTheBoardUseCase clickLikeAtTheBoardUseCase;
    private final GetLikeCountUseCase getLikeCountUseCase;

    @Operation(summary = "해당 게시글에 좋아요를 누릅니다.이미 존재하는 좋아요라면 취소합니다.")
    @PostMapping("/boards/{boardId}/members/{memberId}")
    public ApiResponseDto<String> clickLikeAtTheBoard(@PathVariable Long boardId,
                                                       @PathVariable Long memberId) {
        return ApiResponseDto.onSuccess(clickLikeAtTheBoardUseCase.execute(boardId, memberId));
    }

    @Operation(summary = "해당 게시글의 좋아요 개수를 조회합니다. 주로 게시글 상세 조회에서 사용될 예정입니다.")
    @GetMapping("/boards/{boardId}")
    public ApiResponseDto<Long> getLikeCount(@PathVariable Long boardId) {
        return ApiResponseDto.onSuccess(getLikeCountUseCase.execute(boardId));
    }

}
