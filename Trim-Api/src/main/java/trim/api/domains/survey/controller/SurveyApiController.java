package trim.api.domains.survey.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.survey.service.RegisterSurveyUseCase;
import trim.api.domains.survey.vo.request.SurveyRequest;

@Tag(name = "[설문조사]")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/surveys")
public class SurveyApiController {

    private final RegisterSurveyUseCase registerSurveyUseCase;

    @Operation(summary = "설문조사를 등록합니다.")
    @PostMapping("/members/{memberId}")
    public ApiResponseDto<String> registerSurvey(@PathVariable Long memberId,
                                                 @RequestBody SurveyRequest surveyRequest) {
        return ApiResponseDto.onSuccess(registerSurveyUseCase.execute(memberId, surveyRequest));
    }
}
