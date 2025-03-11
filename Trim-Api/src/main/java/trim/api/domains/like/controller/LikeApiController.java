package trim.api.domains.like.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.like.service.ClickLikeAtTheBoardUseCase;

@Tag(name = "[좋아요🔑]")
@RestController
@RequestMapping("/api/likes")
@RequiredArgsConstructor
public class LikeApiController {

    private final ClickLikeAtTheBoardUseCase clickLikeAtTheBoardUseCase;

    @Operation(summary = "해당 게시글에 좋아요를 누릅니다.이미 존재하는 좋아요라면 취소합니다.")
    @PostMapping("/boards/{boardId}/members/{memberId}")
    public ApiResponseDto<String> clickLikeAtTheBoard(@PathVariable Long boardId,
                                                       @PathVariable Long memberId) {
        return ApiResponseDto.onSuccess(clickLikeAtTheBoardUseCase.execute(boardId, memberId));
    }

}
