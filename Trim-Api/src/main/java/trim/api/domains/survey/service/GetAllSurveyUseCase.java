package trim.api.domains.survey.service;

import lombok.RequiredArgsConstructor;
import trim.common.annotation.UseCase;
import trim.domains.survey.business.adaptor.SurveyAdaptor;
import trim.domains.survey.dao.entity.Survey;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetAllSurveyUseCase {

    private final SurveyAdaptor surveyAdaptor;
    public List<Survey> execute() {
        return surveyAdaptor.queryAll();
    }
}
