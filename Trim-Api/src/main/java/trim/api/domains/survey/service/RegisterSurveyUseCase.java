package trim.api.domains.survey.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import trim.api.domains.survey.vo.request.SurveyRequest;
import trim.common.annotation.UseCase;
import trim.doc.survey.business.service.SurveyDomainService;
import trim.doc.survey.dao.entity.Survey;

@Slf4j
@UseCase
@RequiredArgsConstructor
public class RegisterSurveyUseCase {

    private final SurveyDomainService surveyDomainService;


    public String execute(Long memberId, SurveyRequest surveyRequest) {
        Survey survey = Survey.builder()
                .title(surveyRequest.getTitle())
                .registerMemberId(String.valueOf(memberId))
                .surveyQuestionList(surveyRequest.getSurveyQuestionList())
                .build();
        return surveyDomainService.createSurvey(survey).getId();
    }
}
