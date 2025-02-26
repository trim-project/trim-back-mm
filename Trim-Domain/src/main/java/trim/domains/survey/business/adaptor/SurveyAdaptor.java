package trim.domains.survey.business.adaptor;

import trim.domains.survey.dao.entity.Survey;

import java.util.List;

public interface SurveyAdaptor {

    Survey queryBySurveyId(String surveyId);

    List<Survey> queryAll();
}
