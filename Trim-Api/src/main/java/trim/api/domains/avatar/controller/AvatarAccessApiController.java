package trim.api.domains.avatar.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trim.api.domains.avatar.service.GetHairPartsUseCase;
import trim.api.domains.avatar.vo.response.parts.HairPartsResponse;
import trim.domains.avatar.dao.entity.enums.HairColor;

import java.util.List;

@Tag(name = "[아바타]")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/access/avatar")
public class AvatarAccessApiController {

    private final GetHairPartsUseCase getHairPartsByColorUseCase;

    @Operation(summary = "구매에 상관없이 모든 아바타의 헤어 요소를 조회합니다.")
    @GetMapping("/hair-parts")
    public List<HairPartsResponse> getHairPartsByColor(@RequestParam("color") HairColor color) {
        return getHairPartsByColorUseCase.execute(color);
    }

    
}
