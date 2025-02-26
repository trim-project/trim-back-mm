package trim.api.domains.survey.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.UseCase;
import trim.doc.survey.business.adaptor.SurveyAdaptor;
import trim.doc.survey.dao.entity.Survey;

@UseCase
@RequiredArgsConstructor
public class GetSpecificSurveyUseCase {

    private final SurveyAdaptor surveyAdaptor;

    public Survey execute(String surveyId) {
        return surveyAdaptor.queryBySurveyId(surveyId);
    }
}
