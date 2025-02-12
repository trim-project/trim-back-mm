package trim.api.domains.board.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.board.service.GetAllBoardsByPaginationUseCase;
import trim.api.domains.board.vo.response.BoardSummaryResponse;

import java.util.List;

@Tag(name = "[메인페이지(전체 게시글)]")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/boards")
public class BoardApiController {

    private final GetAllBoardsByPaginationUseCase getAllBoardsByPaginationUseCase;

    @Operation(summary = "모든 게시글을 시간순으로 정렬하여 조회합니다.")
    @GetMapping
    public ApiResponseDto<List<BoardSummaryResponse>> getAllBoardsByPagination(
            @RequestParam(defaultValue = "0") int currentPage,
            @RequestParam int pageSize
    ) {
        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("createdAt").descending());
        return ApiResponseDto.onSuccess(getAllBoardsByPaginationUseCase.execute(pageable));
    }
}
