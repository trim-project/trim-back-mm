package trim.api.domains.survey.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trim.api.common.dto.ApiResponseDto;
import trim.api.domains.survey.service.GetAllSurveyUseCase;
import trim.api.domains.survey.service.GetSpecificSurveyUseCase;
import trim.api.domains.survey.service.RegisterSurveyUseCase;
import trim.api.domains.survey.vo.request.SurveyRequest;
import trim.domains.survey.dao.entity.Survey;

import java.util.List;

@Tag(name = "[설문조사]")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/surveys")
public class SurveyApiController {

    private final RegisterSurveyUseCase registerSurveyUseCase;
    private final GetSpecificSurveyUseCase getSpecificSurveyUseCase;
    private final GetAllSurveyUseCase getAllSurveyUseCase;

    @Operation(summary = "설문조사를 등록합니다.")
    @PostMapping("/members/{memberId}")
    public ApiResponseDto<String> registerSurvey(@PathVariable Long memberId,
                                                 @RequestBody SurveyRequest surveyRequest) {
        return ApiResponseDto.onSuccess(registerSurveyUseCase.execute(memberId, surveyRequest));
    }

    @Operation(summary = "특정 설문조사를 조회합니다.")
    @GetMapping("/{surveyId}")
    public ApiResponseDto<Survey> getSpecificSurvey(@PathVariable String surveyId) {
        return ApiResponseDto.onSuccess(getSpecificSurveyUseCase.execute(surveyId));
    }

    @Operation(summary = "모든 설문조사를 조회합니다.")
    @GetMapping
    public ApiResponseDto<List<Survey>> getAllSurvey() {
        return ApiResponseDto.onSuccess(getAllSurveyUseCase.execute());
    }
}
