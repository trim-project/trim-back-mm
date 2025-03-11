package trim.api.domains.like.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.like.service.GetLikeCountUseCase;

@Tag(name = "[좋아요]")
@RestController
@RequestMapping("/api/access/likes")
@RequiredArgsConstructor
public class LikeAccessApiController {

    private final GetLikeCountUseCase getLikeCountUseCase;

    @Operation(summary = "해당 게시글의 좋아요 개수를 조회합니다. 주로 게시글 상세 조회에서 사용될 예정입니다.")
    @GetMapping("/boards/{boardId}")
    public ApiResponseDto<Long> getLikeCount(@PathVariable Long boardId) {
        return ApiResponseDto.onSuccess(getLikeCountUseCase.execute(boardId));
    }
}
