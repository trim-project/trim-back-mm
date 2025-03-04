package trim.doc.survey.business.adaptor;

import trim.doc.survey.dao.entity.Survey;

import java.util.List;

public interface SurveyAdaptor {

    Survey queryBySurveyId(String surveyId);

    List<Survey> queryAll();
}
